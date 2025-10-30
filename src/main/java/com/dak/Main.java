package com.dak;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import com.dak.controllers.CategoryItemController;
import com.dak.controllers.NewReleaseItemController;
import com.dak.db.Database;
import com.dak.db.tables.CategoryTable;
import com.dak.db.tables.QuizCategoryTable;
import com.dak.models.CategoryModel;
import com.dak.models.QuizModel;
import com.dak.views.*;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.ImageLoader;
import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Main {
    public static final JFrame frame = new JFrame();

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        NewReleaseSectionView newReleaseSectionView;

        try {
            newReleaseSectionView = newReleaseSection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        HomePageViewModel homePageViewModel = new HomePageViewModel(createCategorySection(),newReleaseSectionView );
        HomePageView homePageView = new HomePageView(homePageViewModel);

        contentPane.add(homePageView);

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Contract(" -> new")
    private static @NotNull CategorySectionView createCategorySection() {
        SectionHeaderViewModel sectionHeaderViewModel = new SectionHeaderViewModel("Categories");

        List<CategoryItemView> categoryItemViews = new ArrayList<>();
        List<CategoryModel> categoryModels = CategoryModel.findAll();

        for (CategoryModel categoryModel : categoryModels) {
            CategoryItemViewModel categoryItemViewModel = new CategoryItemViewModel(ImageLoader.load(categoryModel.getImage()));
            CategoryItemView categoryItemView = new CategoryItemView(categoryItemViewModel);
            new CategoryItemController(categoryModel, categoryItemView);

            categoryItemViews.add(categoryItemView);
        }

        CategorySectionViewModel categorySectionViewModel = new CategorySectionViewModel(categoryItemViews.toArray(CategoryItemView[]::new));

        return new CategorySectionView(sectionHeaderViewModel, categorySectionViewModel);
    }

    private static @NotNull NewReleaseSectionView newReleaseSection() throws SQLException {
        List<QuizModel> quizModels = QuizModel.findAll();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        try (Connection conn = Database.getConnection()) {
            String tempTableSql = "CREATE TEMPORARY TABLE temp_quiz_id (quiz_id CHAR(36));";

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(tempTableSql);
            }

            String insertQuizSql = "INSERT INTO temp_quiz_id (quiz_id) VALUES (?)";

            try (PreparedStatement ps = conn.prepareStatement(insertQuizSql)) {
                for (QuizModel quizModel : quizModels) {
                    ps.setString(1, quizModel.getId().toString());
                    ps.addBatch();
                }

                ps.executeBatch();
            }

            String querySql = String.format(
                """
                SELECT
                    tqi.quiz_id,
                    c.%s
                FROM temp_quiz_id tqi
                LEFT JOIN %s qc ON qc.%s = tqi.quiz_id
                LEFT JOIN %s c ON c.%s = qc.%s;
                """,
                CategoryTable.IMAGE,
                QuizCategoryTable.TABLE_NAME,
                QuizCategoryTable.QUIZ_ID,
                CategoryTable.TABLE_NAME,
                CategoryTable.ID,
                QuizCategoryTable.CATEGORY_ID
            );

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(querySql)) {
                while (rs.next()) {
                    String quizId = rs.getString("quiz_id");
                    String image = rs.getString(CategoryTable.IMAGE);

                    hashMap.computeIfAbsent(quizId, (k) -> new ArrayList<>()).add(image);
                }
            }
        }

        SectionHeaderViewModel sectionHeaderViewModel = new SectionHeaderViewModel("New Release");

        List<NewReleaseItemView> newReleaseItemViews = new ArrayList<>();

        for (QuizModel quizModel : quizModels) {
            NewReleaseItemViewModel newReleaseItemViewModel = new NewReleaseItemViewModel(
                quizModel.getTitle(),
                quizModel.getCreator(),
                hashMap.get(quizModel.getId().toString()).toArray(String[]::new)
            );

            NewReleaseItemView newReleaseItemView = new NewReleaseItemView(newReleaseItemViewModel);
            new NewReleaseItemController(quizModel, newReleaseItemView);

            newReleaseItemViews.add(newReleaseItemView);
        }

        NewReleaseSectionViewModel newReleaseSectionViewModel = new NewReleaseSectionViewModel(newReleaseItemViews.toArray(NewReleaseItemView[]::new));

        return new NewReleaseSectionView(sectionHeaderViewModel, newReleaseSectionViewModel);
    }
}

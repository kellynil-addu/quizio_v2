package com.dak;

import java.awt.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import com.dak.db.Database;
import com.dak.db.tables.CategoryTable;
import com.dak.db.tables.QuizCategoryTable;
import com.dak.db.tables.QuizTable;
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

        HomePageViewModel homePageViewModel = new HomePageViewModel(createCategorySection(), newReleaseSection());
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

        List<CategoryItemView> categoryItemViews = ImageLoader.loadAll()
            .stream()
            .map(CategoryItemViewModel::new)
            .map(CategoryItemView::new)
            .toList();

        CategorySectionViewModel categorySectionViewModel = new CategorySectionViewModel(categoryItemViews.toArray(CategoryItemView[]::new));

        return new CategorySectionView(sectionHeaderViewModel, categorySectionViewModel);
    }

    private static @NotNull NewReleaseSectionView newReleaseSection() {
        SectionHeaderViewModel sectionHeaderViewModel = new SectionHeaderViewModel("New Release");

        String query = String.format(
            """
                SELECT
                    q.%s,
                    q.%s,
                    c.%s
                FROM %s q
                LEFT JOIN %s qc ON q.%s = qc.%s
                LEFT JOIN %s c ON qc.%s = c.%s;
            """,
            QuizTable.TITLE,
            QuizTable.CREATOR,
            CategoryTable.IMAGE,
            QuizTable.TABLE_NAME,
            QuizCategoryTable.TABLE_NAME,
            QuizTable.ID,
            QuizCategoryTable.QUIZ_ID,
            CategoryTable.TABLE_NAME,
            QuizCategoryTable.CATEGORY_ID,
            CategoryTable.ID
        );

        String delimiter = "_";

        Map<String, List<String>> map = new LinkedHashMap<>();

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                String title = rs.getString(QuizTable.TITLE);
                String creator = rs.getString(QuizTable.CREATOR);
                String image = rs.getString(CategoryTable.IMAGE);

                String key = title + delimiter + creator;

                map.computeIfAbsent(key, k -> new ArrayList<>()).add(image);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to fetch data for new release section: " + ex);
        }

        List<NewReleaseItemView> newReleaseItemViews = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String[] keyValue = entry.getKey().split(delimiter);
            String title = keyValue[0];
            String creator = keyValue[1];
            String[] images = entry.getValue().toArray(String[]::new);

            NewReleaseItemViewModel newReleaseItemViewModel = new NewReleaseItemViewModel(title, creator, images);
            NewReleaseItemView newReleaseItemView = new NewReleaseItemView(newReleaseItemViewModel);

            newReleaseItemViews.add(newReleaseItemView);
        }

        NewReleaseSectionViewModel newReleaseSectionViewModel = new NewReleaseSectionViewModel(newReleaseItemViews.toArray(NewReleaseItemView[]::new));

        return new NewReleaseSectionView(sectionHeaderViewModel, newReleaseSectionViewModel);
    }
}

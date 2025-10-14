package com.dak;

import java.awt.*;

import javax.swing.*;

import com.dak.views.components.*;
import org.flywaydb.core.Flyway;

import com.dak.configs.EnvironmentVariable;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static JFrame frame = new JFrame();
    public static JPanel cardPanel = new JPanel(new CardLayout());

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        cardPanel.setOpaque(false);
        cardPanel.add(new FillInTheBlankPanel(), "1");
        cardPanel.add(new MultipleChoicePanel(), "2");
        cardPanel.add(new MultiSelectPanel(), "3");
        cardPanel.add(new TrueOrFalsePanel(), "4");

        contentPane.add(cardPanel);

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Runs all pending migrations on the database.
     *
     * <p>Note: For best practice, consider integrating this functionality as a separate
     * console command instead of invoking it directly within the application code.</p>
     */
    private static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        EnvironmentVariable.DATABASE_URL,
                        EnvironmentVariable.DATABASE_USER,
                        EnvironmentVariable.DATABASE_PASSWORD
                )
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}

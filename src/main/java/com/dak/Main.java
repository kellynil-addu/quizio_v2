package com.dak;

import java.awt.*;

import javax.swing.*;

import com.dak.views.AppPage;
import com.dak.views.HomePage;
import com.dak.views.components.AppMenuBar;

import org.flywaydb.core.Flyway;

import com.dak.configs.EnvironmentVariable;
import com.dak.views.utils.AppTheme;
import com.dak.views.utils.SizeSet;

public class Main {
    public static JFrame frame = new JFrame();
    public static JMenuBar menuBar;
    public static AppPage page;

    public static void main(String[] args) {
        // migrate(); if (true) return;

        AppTheme.initialize();

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(Color.RED);
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));
        switchPage(new HomePage());

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setMinimumSize(new Dimension(960, 720));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuBar = new AppMenuBar();
        frame.setJMenuBar(new AppMenuBar());
        
        frame.setVisible(true);
    }

    public static void switchPage(AppPage newPage) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        if (page != null) {
            page.setVisible(false);
            contentPane.remove(page);
        }
        page = newPage;
        contentPane.add(page);
        contentPane.repaint();
    }

    public static void refreshPage() {
        switchPage(page.cloneState());
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

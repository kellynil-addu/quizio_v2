package com.dak;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.dak.views.HomePage;
import org.flywaydb.core.Flyway;

import com.dak.configs.EnvironmentVariable;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        UIManager.put("Label.foreground", ColorSet.PRIMARY_FOREGROUND);

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));
        contentPane.add(new HomePage());

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

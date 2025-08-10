package com.dak;

import com.dak.configs.EnvironmentVariable;
import com.dak.views.NewReleaseSection;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import org.flywaydb.core.Flyway;

import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        UIManager.put("Label.foreground", ColorSet.PRIMARY_FOREGROUND);

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        frame.add(new NewReleaseSection());
        frame.setSize(1920, 1080);
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

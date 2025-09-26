package com.dak.views.utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

import com.dak.Main;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class AppTheme {
    private static boolean isLightMode;
    
    private static Color primaryBackground;
    private static Color secondaryBackground;
    private static Color primaryForeground;
    private static Color secondaryForeground;
    private static Color primaryButton;

    public static void initialize() {
        toDarkMode();
    }
    
    public static void refresh() {
        UIManager.put( "Button.arc", 6 );
        UIManager.put( "Button.borderWidth", 0);
        UIManager.put("defaultFont",  new javax.swing.plaf.FontUIResource("Inter", Font.PLAIN, 13));
        UIManager.put("Label.foreground", getPrimaryForeground());
        UIManager.put("Panel.background", getPrimaryBackground());
        UIManager.put("ScrollBar.background", getPrimaryBackground());

        if (Main.page != null) {
            Main.frame.setJMenuBar(Main.menuBar);
            Main.frame.repaint();
            Main.refreshPage();
            Main.frame.getContentPane().setBackground(getPrimaryBackground());
        } 

    }

    public static void toggleTheme() {
        if (isLightMode) {
            toDarkMode();
        } else {
            toLightMode();
        }
    }
    
    public static void toLightMode() {
        isLightMode = true;
        primaryBackground = Color.decode("#FFFFFF");
        secondaryBackground = Color.decode("#E2E2E2");
        primaryForeground = Color.decode("#353535");
        secondaryForeground = Color.decode("#FFFFFF");
        primaryButton = Color.decode("#1B98FF");
        FlatLightLaf.setup();
        refresh();
    }
    
    public static void toDarkMode() {
        isLightMode = false;
        primaryBackground = Color.decode("#252525");
        secondaryBackground = Color.decode("#353535");
        primaryForeground = Color.decode("#FFFFFF");
        secondaryForeground = Color.decode("#FFFFFF");
        primaryButton = Color.decode("#1B98FF");
        FlatDarkLaf.setup();
        refresh();
    }

    public static Color getPrimaryBackground() {
        return primaryBackground;
    }

    public static Color getSecondaryBackground() {
        return secondaryBackground;
    }

    public static Color getPrimaryForeground() {
        return primaryForeground;
    }

    public static Color getSecondaryForeground() {
        return secondaryForeground;
    }

    public static Color getPrimaryButton() {
        return primaryButton;
    }
}
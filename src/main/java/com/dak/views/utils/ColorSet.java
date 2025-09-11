package com.dak.views.utils;

import java.awt.Color;

public class ColorSet {
    private static Color primaryBackground;
    private static Color secondaryBackground;
    private static Color primaryForeground;
    private static Color secondaryForeground;
    private static Color primaryButton;

    static {
        // Set default color theme.
        toDarkMode();
    }

    public static void toLightMode() {
        primaryBackground = Color.decode("#FFFFFF");
        secondaryBackground = Color.decode("#E2E2E2");
        primaryForeground = Color.decode("#353535");
        secondaryForeground = Color.decode("#FFFFFF");
        primaryButton = Color.decode("#1B98FF");
    }

    public static void toDarkMode() {
        primaryBackground = Color.decode("#252525");
        secondaryBackground = Color.decode("#353535");
        primaryForeground = Color.decode("#FFFFFF");
        secondaryForeground = Color.decode("#FFFFFF");
        primaryButton = Color.decode("#1B98FF");
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
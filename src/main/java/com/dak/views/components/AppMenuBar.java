package com.dak.views.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dak.views.utils.AppTheme;

public class AppMenuBar extends JMenuBar {
    public AppMenuBar() {
        this.add(createApplicationMenu());
    }

    private static JMenu createApplicationMenu() {
        JMenu menu = new JMenu("Application");

        JMenuItem themeToggleItem = new JMenuItem("Toggle Light/Dark Theme");
        themeToggleItem.addActionListener(e -> AppTheme.toggleTheme());
        menu.add(themeToggleItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);

        return menu;
    }
}

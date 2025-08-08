package com.dak;

import com.dak.db.Migrator;
import com.dak.views.NewReleaseSection;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        UIManager.put("Label.foreground", ColorSet.PRIMARY_FOREGROUND);

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        frame.add(new NewReleaseSection());
        frame.setSize(1024, 762);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

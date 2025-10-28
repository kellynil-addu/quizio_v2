package com.dak;

import java.awt.*;

import javax.swing.*;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static final JFrame frame = new JFrame();

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

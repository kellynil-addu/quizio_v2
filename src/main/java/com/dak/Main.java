package com.dak;

import java.awt.*;

import javax.swing.*;

import com.dak.composers.HomePageComposer;
import com.dak.constants.AppConstants;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static final JFrame frame = new JFrame();
    public static final JPanel cardPanel = new JPanel(new CardLayout());

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        cardPanel.setOpaque(false);
        cardPanel.add(HomePageComposer.createHomePage(), AppConstants.HOME_PAGE);

        contentPane.add(cardPanel);

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

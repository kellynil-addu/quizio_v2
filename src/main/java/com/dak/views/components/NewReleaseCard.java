package com.dak.views.components;

import com.dak.Main;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.ImageSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class NewReleaseCard extends JPanel {
    public NewReleaseCard(String title, String creator) {
        setLayout(new BorderLayout());
        setBackground(ColorSet.getSecondaryBackground());
        setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(ColorSet.getPrimaryForeground());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));

        JLabel creatorLabel = new JLabel("By " + creator);
        creatorLabel.setForeground(ColorSet.getPrimaryForeground());
        creatorLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        creatorLabel.setFont(titleLabel.getFont().deriveFont(Font.PLAIN, SizeSet.XS));

        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(titleLabel);
        leftPanel.add(creatorLabel);
        leftPanel.add(Box.createVerticalGlue());

        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setOpaque(false);

        JLabel htmlLogo = new JLabel(ImageSet.getIconFromSVG("html.svg", SizeSet._3XL, SizeSet._3XL));
        JLabel cssLogo = new JLabel(ImageSet.getIconFromSVG("css.svg", SizeSet._3XL, SizeSet._3XL));

        categoriesPanel.add(htmlLogo);
        categoriesPanel.add(cssLogo);

        JButton button = new PrimaryButton("Play");
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setPreferredSize(new Dimension(button.getPreferredSize().width, SizeSet._3XL));

        CardLayout cardLayout = (CardLayout) Main.appPanel.getLayout();

        button.addActionListener(e -> cardLayout.show(Main.appPanel, "quiz"));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rightPanel.setOpaque(false);
        rightPanel.add(categoriesPanel);
        rightPanel.add(button);

        add(leftPanel);
        add(rightPanel, BorderLayout.EAST);
    }
}

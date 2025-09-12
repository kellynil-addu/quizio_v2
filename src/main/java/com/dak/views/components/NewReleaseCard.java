package com.dak.views.components;

import com.dak.Main;
import com.dak.views.DummyPage;
import com.dak.views.utils.AppTheme;
import com.dak.views.utils.ImageSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class NewReleaseCard extends JPanel {
    public NewReleaseCard(String title, String creator) {
        setLayout(new BorderLayout());
        setBackground(AppTheme.getSecondaryBackground());
        setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(AppTheme.getPrimaryForeground());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        
        JLabel creatorLabel = new JLabel("By " + creator);
        creatorLabel.setForeground(AppTheme.getPrimaryForeground());
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

        JLabel htmlLogo = new JLabel(ImageSet.getCachedIconFromSVG("html.svg", SizeSet._3XL, SizeSet._3XL));
        JLabel cssLogo = new JLabel(ImageSet.getCachedIconFromSVG("css.svg", SizeSet._3XL, SizeSet._3XL));

        categoriesPanel.add(htmlLogo);
        categoriesPanel.add(cssLogo);

        JButton button = new PrimaryButton("Play");
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.addActionListener(e -> Main.switchPage(new DummyPage(title)));
        button.setPreferredSize(new Dimension(button.getPreferredSize().width, SizeSet._3XL));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rightPanel.setOpaque(false);
        rightPanel.add(categoriesPanel);
        rightPanel.add(button);

        add(leftPanel);
        add(rightPanel, BorderLayout.EAST);
    }
}

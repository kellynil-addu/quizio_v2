package com.dak;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.dak.controllers.*;
import com.dak.views.*;
import com.dak.views.vms.*;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static final JFrame frame = new JFrame();

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        // Uncomment one at a time to test.

        contentPane.add(DummyUIFactory.homePage());
        // contentPane.add(DummyUIFactory.fillInBlankPage());
        // contentPane.add(DummyUIFactory.multipleChoicePage());
        // contentPane.add(DummyUIFactory.multiSelectPage());
        // contentPane.add(DummyUIFactory.trueOrFalsePage());

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

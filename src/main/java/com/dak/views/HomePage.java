/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dak.views;

import com.dak.views.components.CategorySection;
import com.dak.views.components.NewReleaseSection;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HomePage extends JPanel {
    public HomePage() {
        this.setLayout(new BorderLayout());
        this.add(new HeroSection(), BorderLayout.NORTH);
        this.add(new CategorySection(), BorderLayout.NORTH);
        this.add(new NewReleaseSection(), BorderLayout.CENTER);

        final JPanel nestedPanel = new JPanel();

        this.setLayout(new BorderLayout());
        this.add(new HeroSection(), BorderLayout.NORTH);

        nestedPanel.setLayout(new BorderLayout());
        nestedPanel.add(new CategorySection(), BorderLayout.NORTH);
        nestedPanel.add(new NewReleaseSection());
        this.add(nestedPanel);
    }
}

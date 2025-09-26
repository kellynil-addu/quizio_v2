/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dak.views;

import com.dak.views.components.CategorySection;
import com.dak.views.components.HeroSection;
import com.dak.views.components.NewReleaseSection;
import com.dak.views.utils.AppTheme;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HomePage extends AppPage {
    public HomePage() {
        this.setOpaque(false);

        final JPanel nestedPanel = new JPanel();

        this.setLayout(new BorderLayout());
        this.add(new HeroSection(), BorderLayout.NORTH);

        nestedPanel.setLayout(new BorderLayout());
        nestedPanel.add(new CategorySection(), BorderLayout.NORTH);
        nestedPanel.add(new NewReleaseSection());
        nestedPanel.setOpaque(false);
        this.add(nestedPanel);
    }

    @Override
    public AppPage cloneState() {
        return new HomePage();
    }
}

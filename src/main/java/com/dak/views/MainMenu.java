/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dak.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 *
 * @author kelly
 */
public class MainMenu extends JPanel {
    public MainMenu() {
        // this.setLayout(new GridBagLayout());
        // GridBagConstraints gbc = new GridBagConstraints();
        
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.fill = GridBagConstraints.BOTH;
        // gbc.weightx = 1.0;
        // // gbc.weighty = 0.0;
        // this.add(new CategorySection(), gbc);

        // gbc.gridy++;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1.0;
        // gbc.weighty = 1.0;
        // this.add(new NewReleaseSection(), gbc);

        // FIXME: Temporary fix, until a more dynamic solution is found
        this.setLayout(new BorderLayout()); 

        this.add(new CategorySection(), BorderLayout.NORTH);
        this.add(new NewReleaseSection(), BorderLayout.CENTER);
    }
}

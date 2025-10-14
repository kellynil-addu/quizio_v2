/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dak.views.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HomePage extends JPanel {
    public HomePage() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(new CategorySection(), BorderLayout.NORTH);
        this.add(new NewReleaseSection(), BorderLayout.CENTER);
    }
}

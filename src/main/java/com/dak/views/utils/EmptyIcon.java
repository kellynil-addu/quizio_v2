package com.dak.views.utils;

import javax.swing.*;
import java.awt.*;

public class EmptyIcon implements Icon {
    public int getIconWidth() { return 0; }
    public int getIconHeight() { return 0; }
    public void paintIcon(Component c, Graphics g, int x, int y) {}
}
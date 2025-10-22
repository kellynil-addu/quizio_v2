package com.dak.views.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    private static final String IMAGE_DIR = "src/main/resources/assets/images/";

    public static @NotNull ImageIcon load(String image, int w, int h) {
        ImageIcon originalIcon = new ImageIcon(IMAGE_DIR + image);
        Image scaledImage = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }
}
package com.dak.views.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {
    private static final String IMAGE_DIR = "src/main/resources/assets/images/";

    public static @NotNull ImageIcon load(@NotNull String image) {
        return new ImageIcon(IMAGE_DIR + image);
    }

    public static @NotNull ImageIcon load(@NotNull String image, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(IMAGE_DIR + image);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static @NotNull List<ImageIcon> loadAll() {
        List<ImageIcon> icons = new ArrayList<>();
        Path imagesPath = Paths.get(IMAGE_DIR);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(imagesPath)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file) && !file.getFileName().toString().startsWith(".")) {
                    icons.add(new ImageIcon(file.toString()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read images directory: " + e);
        }

        return icons;
    }

    public static @NotNull List<ImageIcon> loadAll(int width, int height) {
        return loadAll().stream()
                .map(icon -> new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)))
                .toList();
    }
}
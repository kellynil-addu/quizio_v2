package com.dak.views.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

import com.github.weisj.jsvg.SVGDocument;
import com.github.weisj.jsvg.parser.SVGLoader;
import com.github.weisj.jsvg.view.ViewBox;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ImageSet {
    private static final String IMAGES_DIR = "/assets/images";
    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;

    public static final ImageIcon CSS_LOGO = getIconFromSVG(IMAGES_DIR + "/css.svg");
    public static final ImageIcon HTML_LOGO = getIconFromSVG(IMAGES_DIR + "/html.svg");

    @Contract("_ -> new")
    private static @NotNull ImageIcon getIconFromSVG(String fileName) {
        SVGLoader loader = new SVGLoader();
        URL svgUrl = ImageSet.class.getResource(fileName);

        if (svgUrl == null) {
            throw new IllegalArgumentException("Resource not found: " + fileName);
        }

        SVGDocument svgDocument = loader.load(svgUrl);

        if (svgDocument == null) {
            throw new IllegalArgumentException("Failed to load SVG from: " + fileName);
        }

        BufferedImage image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        svgDocument.render(null, g, new ViewBox(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        g.dispose();

        return new ImageIcon(image);
    }
}

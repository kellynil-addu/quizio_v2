package com.dak.views.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

import com.github.weisj.jsvg.SVGDocument;
import com.github.weisj.jsvg.parser.SVGLoader;
import com.github.weisj.jsvg.view.ViewBox;

public class ImageSet {
    public static final ImageIcon ICON_CATEGORY_CSS = getIconFromSVG("/assets/images/css.svg", 48, 48);
    public static final ImageIcon ICON_CATEGORY_HTML = getIconFromSVG("/assets/images/html.svg", 48, 48);

    private static ImageIcon getIconFromSVG(String fileName, int width, int length) {
        SVGLoader loader = new SVGLoader();
        URL svgUrl = ImageSet.class.getResource(fileName);
        SVGDocument svgDocument = loader.load(svgUrl);
        // FloatSize size = svgDocument.size();
        BufferedImage image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setBackground(Color.RED);
        svgDocument.render(null,g, new ViewBox(width, length));
        g.dispose();

        return new ImageIcon(image);
    }


}

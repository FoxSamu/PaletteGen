package net.shadew.palette;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import net.shadew.util.misc.ColorUtil;

public class PaletteTest {
    public static void main(String[] args) throws Exception {
        int paletteSize = 5;
        int mainColor = 0x3530c2;
        double hueshift = -25;
        double proportion = 0.5;
        double bias = 1.1;
        double extra = 1;


        int[] palette = PaletteGenerator.generateUpliftPalette(
            new Random(),
            mainColor,
            paletteSize,
            hueshift,
            proportion,
            bias,
            extra,
            0.00,
            0.00,
            0.00,
            0.16
        );

        BufferedImage img = new BufferedImage(paletteSize * 32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        for(int i = 0; i < paletteSize; i++) {
            int x = i * 32;
            g2d.setColor(new Color(palette[i]));
            g2d.fillRect(x, 0, 32, 32);
            System.out.println(ColorUtil.toHexString(palette[i]));
        }
        ImageIO.write(img, "PNG", new File("./palette.png"));
    }
}

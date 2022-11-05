package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
public class Convert {
    private int height;
    private int width;
    private char black;
    private char white;
    private BufferedImage bufferedImage;

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bufferedImage.getRGB(j, i) == -1) {
                    System.out.print(white);
                }
                else {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }

    public Convert(InputStream path, char white, char black) {
        this.white = white;
        this.black = black;
        try {
            bufferedImage = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        height = bufferedImage.getHeight();
        width = bufferedImage.getWidth();
    }
}
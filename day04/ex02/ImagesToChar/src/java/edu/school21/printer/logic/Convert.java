package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcolor.Attribute;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

@Parameters(separators = "=")
public class Convert {
    private BufferedImage bufferedImage;
    @Parameter(names = "--white")
    private String white;
    @Parameter(names = "--black")
    private String black;
    private int height;
    private int width;

    public void print() {
        Attribute color;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bufferedImage.getRGB(j, i) == -1) {
                    color = BACK_COLOR(getColor(white));
                    System.out.print(colorize("   ", color));
                }
                else {
                    color = BACK_COLOR(getColor(black));
                    System.out.print(colorize("   ", color));
                }
            }
            System.out.println();
        }
    }

    public Convert(InputStream path) {
        try {
            this.bufferedImage = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        height = bufferedImage.getHeight();
        width = bufferedImage.getWidth();
    }

    public int getColor(String color) {
        switch (color) {
            case "RED":
                return 160;
            case "GREEN":
                return 2;
            case "WHITE":
                return 255;
            case "BLUE":
                return 27;
            case "YELLOW":
                return 11;
            default: return 0;
        }
    }
}
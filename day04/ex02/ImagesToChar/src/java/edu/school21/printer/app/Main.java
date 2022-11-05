package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;
import com.beust.jcommander.JCommander;

public class Main {
    private static char whiteSumbolColor;
    private static char blackSumbolColor;
    public static void main(String[] args) {
        InputStream inputStream =  Main.class.getResourceAsStream("/resources/it.bmp");
        Convert convert = new Convert(inputStream);

        JCommander.newBuilder().addObject(convert).build().parse(args);

        convert.print();
    }
}

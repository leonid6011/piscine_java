package edu.school21.printer;

import edu.school21.renderer.Renderer;
import edu.school21.printer.Printer;

import java.util.Date;

public class PrinterWithDateTimeImpl implements Printer {
    private Date date = new Date();
    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String str) {
        renderer.print(date.toString() + " " + str);
    }
}
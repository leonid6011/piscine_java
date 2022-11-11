package edu.school21.printer;

import edu.school21.renderer.Renderer;
import edu.school21.printer.Printer;
public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String str) {
        renderer.print(this.prefix + str);
    }
}
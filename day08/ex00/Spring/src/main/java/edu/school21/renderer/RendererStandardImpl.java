package edu.school21.renderer;

import edu.school21.renderer.Renderer;
import edu.school21.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String str) {
        str = preProcessor.preProcessor(str);
        System.out.println(str);
    }
}
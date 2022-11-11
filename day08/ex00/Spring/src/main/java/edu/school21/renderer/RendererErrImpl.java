package edu.school21.renderer;

import edu.school21.renderer.Renderer;
import edu.school21.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String str) {
        str = preProcessor.preProcessor(str);
        System.err.println(str);
    }
}
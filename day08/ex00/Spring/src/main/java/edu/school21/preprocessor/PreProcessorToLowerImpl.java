package edu.school21.preprocessor;

import edu.school21.preprocessor.PreProcessor;

public class PreProcessorToLowerImpl implements PreProcessor {
    @Override
    public String preProcessor(String str) {
        return str.toLowerCase();
    }
}
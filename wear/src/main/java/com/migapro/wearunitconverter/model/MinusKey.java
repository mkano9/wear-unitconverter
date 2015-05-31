package com.migapro.wearunitconverter.model;

public class MinusKey extends NumberPadKey {

    private static final char MINUS = '-';

    @Override
    public String processKey(String currentInput) {
        if (currentInput.charAt(0) != MINUS) {
            return MINUS + currentInput;
        }
        return currentInput;
    }
}

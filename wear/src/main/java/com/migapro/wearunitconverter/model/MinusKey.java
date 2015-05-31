package com.migapro.wearunitconverter.model;

import com.migapro.wearunitconverter.utility.NumberPadUtility;

public class MinusKey extends NumberPadKey {

    private static final char MINUS = '-';

    @Override
    public String processKey(String currentInput) {
        if (!NumberPadUtility.isFirstLetterNegativeSign(currentInput)) {
            return MINUS + currentInput;
        }
        return currentInput;
    }
}

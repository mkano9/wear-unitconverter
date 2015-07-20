package com.migapro.wearunitconverter.model.numberpadkey;

import com.migapro.wearunitconverter.utility.NumberPadUtil;

public class MinusKey extends NumberPadKey {

    private static final char MINUS = '-';

    @Override
    public String processKey(String currentInput) {
        if (NumberPadUtil.isFirstLetterNegativeSign(currentInput)) {
            return currentInput.substring(1);
        }

        return MINUS + currentInput;
    }
}

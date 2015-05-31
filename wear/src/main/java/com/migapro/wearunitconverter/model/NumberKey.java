package com.migapro.wearunitconverter.model;

public class NumberKey extends NumberPadKey {

    private String mNumber;

    public NumberKey(String number) {
        mNumber = number;
    }

    @Override
    public String processKey(String currentInput) {
        if (currentInput.length() == 1 && currentInput.charAt(0) == '0') {
            return mNumber;
        }
        return currentInput + mNumber;
    }
}

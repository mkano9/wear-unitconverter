package com.migapro.wearunitconverter.model;

import com.migapro.wearunitconverter.utility.NumberPadUtility;

public class NumberKey extends NumberPadKey {

    private String mNumber;

    public NumberKey(String number) {
        mNumber = number;
    }

    @Override
    public String processKey(String currentInput) {
        if (NumberPadUtility.isOnlyZero(currentInput)) {
            return mNumber;
        } else if (NumberPadUtility.isNegativeZero(currentInput)) {
            return '-' + mNumber;
        }

        return currentInput + mNumber;
    }
}

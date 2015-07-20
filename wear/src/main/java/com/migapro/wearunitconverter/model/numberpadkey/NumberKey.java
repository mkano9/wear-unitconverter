package com.migapro.wearunitconverter.model.numberpadkey;

import com.migapro.wearunitconverter.utility.NumberPadUtil;

public class NumberKey extends NumberPadKey {

    private String mNumber;

    public NumberKey(String number) {
        mNumber = number;
    }

    @Override
    public String processKey(String currentInput) {
        if (NumberPadUtil.isOnlyZero(currentInput)) {
            return mNumber;
        } else if (NumberPadUtil.isNegativeZero(currentInput)) {
            return '-' + mNumber;
        }

        return currentInput + mNumber;
    }
}

package com.migapro.wearunitconverter.model.numberpadkey;

public class DecimalPeriodKey extends NumberPadKey {

    private static final CharSequence DECIMAL_PERIOD = ".";

    @Override
    public String processKey(String currentInput) {
        if (!currentInput.contains(DECIMAL_PERIOD)) {
            return currentInput + DECIMAL_PERIOD;
        }
        return currentInput;
    }
}

package com.migapro.wearunitconverter.model;

import com.migapro.wearunitconverter.utility.NumberPadUtility;

public class SingleDeleteKey extends NumberPadKey {
    @Override
    public String processKey(String currentInput) {
        if (!currentInput.isEmpty()) {
            String processedInput = currentInput.substring(0, currentInput.length() - 1);

            if (processedInput.isEmpty()
                    || NumberPadUtility.isOnlyNegativeSign(processedInput)) {
                processedInput = "0";
            }
            return processedInput;
        }

        return "0";
    }
}
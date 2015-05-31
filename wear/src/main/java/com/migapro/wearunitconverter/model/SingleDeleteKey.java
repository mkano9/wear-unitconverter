package com.migapro.wearunitconverter.model;

public class SingleDeleteKey extends NumberPadKey {
    @Override
    public String processKey(String currentInput) {
        if (!currentInput.isEmpty()) {
            String processedInput = currentInput.substring(0, currentInput.length() - 1);

            if (processedInput.isEmpty() ||
                    (processedInput.length() == 1 && processedInput.charAt(0) == '-')) {
                processedInput = "0";
            }
            return processedInput;
        }

        return "0";
    }
}
package com.migapro.wearunitconverter.model.numberpadkey;

public class ClearKey extends NumberPadKey {
    @Override
    public String processKey(String currentInput) {
        return "0";
    }
}

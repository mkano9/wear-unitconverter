package com.migapro.wearunitconverter.model;

public class ClearKey extends NumberPadKey {
    @Override
    public String processKey(String currentInput) {
        return "0";
    }
}

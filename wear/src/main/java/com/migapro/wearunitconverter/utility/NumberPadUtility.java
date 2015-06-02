package com.migapro.wearunitconverter.utility;

import com.migapro.wearunitconverter.model.numberpadkey.ClearKey;
import com.migapro.wearunitconverter.model.numberpadkey.DecimalPeriodKey;
import com.migapro.wearunitconverter.model.numberpadkey.MinusKey;
import com.migapro.wearunitconverter.model.numberpadkey.NumberKey;
import com.migapro.wearunitconverter.model.numberpadkey.NumberPadKey;
import com.migapro.wearunitconverter.model.numberpadkey.SingleDeleteKey;

public class NumberPadUtility {

    public static NumberPadKey generateNumberPadKey(String keyPressed) {
        NumberPadKey numberPadKey;

        if (keyPressed.equals("C")) {
            numberPadKey = new ClearKey();
        } else if (keyPressed.equals("-")) {
            numberPadKey = new MinusKey();
        } else if (keyPressed.equals(".")) {
            numberPadKey = new DecimalPeriodKey();
        } else if (keyPressed.equals("x")) {
            numberPadKey = new SingleDeleteKey();
        } else {
            numberPadKey = new NumberKey(keyPressed);
        }

        return numberPadKey;
    }

    public static boolean isNegativeZero(String number) {
        return (number.length() == 2
                && number.charAt(0) == '-'
                && number.charAt(1) == '0');
    }

    public static boolean isFirstLetterNegativeSign(String input) {
        return (input.charAt(0) == '-');
    }

    public static boolean isOnlyZero(String input) {
        return (input.length() == 1 && input.charAt(0) == '0');
    }

    public static boolean isOnlyNegativeSign(String input) {
        return (input.length() == 1 && input.charAt(0) == '-');
    }

    public static boolean isLastCharPeriod(String input) {
        return (input.charAt(input.length() - 1) == '.');
    }
}

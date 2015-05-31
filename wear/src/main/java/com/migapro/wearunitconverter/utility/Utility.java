package com.migapro.wearunitconverter.utility;

import com.migapro.wearunitconverter.model.ClearKey;
import com.migapro.wearunitconverter.model.DecimalPeriodKey;
import com.migapro.wearunitconverter.model.MinusKey;
import com.migapro.wearunitconverter.model.NumberKey;
import com.migapro.wearunitconverter.model.NumberPadKey;
import com.migapro.wearunitconverter.model.SingleDeleteKey;

public class Utility {

    public static NumberPadKey generateNumberKey(String keyPressed) {
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
}

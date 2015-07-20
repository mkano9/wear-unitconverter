package com.migapro.wearunitconverter.model.arithmetic;

import android.content.Context;

import com.migapro.wearunitconverter.model.Input;
import com.migapro.wearunitconverter.utility.Constants;

import java.math.BigDecimal;

public class Length implements Arithmetic {

    private String[] mUnitValuesArray;

    public Length(Context context, int measurementType) {
        mUnitValuesArray = context.getResources()
                .getStringArray(Constants.UNIT_VALUES_RESOURCE_IDS[measurementType]);
    }

    @Override
    public String convert(Input input) {
        BigDecimal numberFrom = new BigDecimal(input.getNumFrom());
        BigDecimal unitFromValue = new BigDecimal(mUnitValuesArray[input.getUnitFromIndex()]);
        BigDecimal unitToValue = new BigDecimal(mUnitValuesArray[input.getUnitToIndex()]);

        BigDecimal numConvertedToBase = numberFrom.multiply(unitFromValue);
        BigDecimal result = numConvertedToBase.divide(unitToValue);

        return result.toPlainString();
    }
}

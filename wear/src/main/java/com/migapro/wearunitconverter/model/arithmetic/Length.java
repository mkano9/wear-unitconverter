package com.migapro.wearunitconverter.model.arithmetic;

import android.content.Context;

import com.migapro.wearunitconverter.model.Conversion;
import com.migapro.wearunitconverter.utility.Constants;

import java.math.BigDecimal;

public class Length implements Arithmetic {

    private String[] mUnitValuesArray;

    public Length(Context context, int measurementType) {
        mUnitValuesArray = context.getResources()
                .getStringArray(Constants.UNIT_VALUES_RESOURCE_IDS[measurementType]);
    }

    @Override
    public String convert(Conversion conversion) {
        BigDecimal numberFrom = new BigDecimal(conversion.getNumFrom());
        BigDecimal unitFromValue = new BigDecimal(mUnitValuesArray[conversion.getUnitFromIndex()]);
        BigDecimal unitToValue = new BigDecimal(mUnitValuesArray[conversion.getUnitToIndex()]);

        BigDecimal numConvertedToBase = numberFrom.multiply(unitFromValue);
        BigDecimal result = numConvertedToBase.divide(unitToValue);

        return result.toPlainString();
    }
}

package com.migapro.wearunitconverter.model;

import android.content.Context;

import com.migapro.wearunitconverter.utility.Constants;

import java.math.BigDecimal;

public class Conversion {

    private String mNumFrom;
    private String mNumTo;
    private UnitList mUnitList;
    private int mUnitToIndex;
    private int mUnitFromIndex;
    private int mMeasurementType;

    public Conversion(Context context) {
        mNumFrom = "0";
        mNumTo = "0";
        loadUnitsList(context);
    }

    public void loadUnitsList(Context context) {
        String[] unitNamesArray =
                context.getResources().getStringArray(Constants.UNIT_NAMES_RESOURCE_IDS[mMeasurementType]);
        String[] unitValuesArray =
                context.getResources().getStringArray(Constants.UNIT_VALUES_RESOURCE_IDS[mMeasurementType]);
        
        mUnitList = new UnitList(unitNamesArray, unitValuesArray);
        mUnitToIndex = 0;
        mUnitFromIndex = 0;
    }

    public void convertNumber() {
        BigDecimal numberFrom = new BigDecimal(mNumFrom);
        BigDecimal unitFromValue = new BigDecimal(mUnitList.getUnitValue(mUnitFromIndex));
        BigDecimal unitToValue = new BigDecimal(mUnitList.getUnitValue(mUnitToIndex));

        BigDecimal numConvertedToBase = numberFrom.multiply(unitFromValue);
        BigDecimal result = numConvertedToBase.divide(unitToValue);
        mNumTo = result.toPlainString();
    }

    public String getNumFrom() {
        return mNumFrom;
    }

    public String getUnitFromName() {
        return mUnitList.getUnitNames()[mUnitFromIndex];
    }

    public String getNumTo() {
        return mNumTo;
    }

    public String getUnitToName() {
        return mUnitList.getUnitNames()[mUnitToIndex];
    }

    public String[] getUnitNamesList() {
        return mUnitList.getUnitNames();
    }

    public void setNumFrom(String numFrom) {
        mNumFrom = numFrom;
    }

    public void setUnitFrom(int unitFrom) {
        mUnitFromIndex = unitFrom;
    }

    public void setUnitTo(int unitTo) {
        mUnitToIndex = unitTo;
    }

    public void setMeasurementType(int measurementType) {
        mMeasurementType = measurementType;
    }
}

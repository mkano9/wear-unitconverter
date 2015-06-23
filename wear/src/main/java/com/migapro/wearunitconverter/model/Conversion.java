package com.migapro.wearunitconverter.model;

import android.content.Context;

import com.migapro.wearunitconverter.utility.Constants;

import java.math.BigDecimal;

public class Conversion {

    private String mNumFrom;
    private String mNumTo;

    private UnitList mUnitList;
    private int mUnitTo;
    private int mUnitFrom;
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
        mUnitTo = 0;
        mUnitFrom = 0;
    }

    public void convertNumber() {
        BigDecimal numberFrom = new BigDecimal(mNumFrom);
        BigDecimal unitFromValue = new BigDecimal(mUnitList.getUnitValue(mUnitFrom));
        BigDecimal unitToValue = new BigDecimal(mUnitList.getUnitValue(mUnitTo));

        BigDecimal numConvertedToBase = numberFrom.multiply(unitFromValue);
        BigDecimal result = numConvertedToBase.divide(unitToValue);
        mNumTo = result.toPlainString();
    }

    public String getNumFrom() {
        return mNumFrom;
    }

    public String getUnitFromName() {
        return mUnitList.getUnitNames()[mUnitFrom];
    }

    public String getNumTo() {
        return mNumTo;
    }

    public String getUnitToName() {
        return mUnitList.getUnitNames()[mUnitTo];
    }

    public String[] getUnitNamesList() {
        return mUnitList.getUnitNames();
    }

    public void setNumFrom(String mNumFrom) {
        this.mNumFrom = mNumFrom;
    }

    public void setUnitFrom(int mUnitFrom) {
        this.mUnitFrom = mUnitFrom;
    }

    public void setUnitTo(int mUnitTo) {
        this.mUnitTo = mUnitTo;
    }

    public void setMeasurementType(int measurementType) {
        mMeasurementType = measurementType;
    }
}

package com.migapro.wearunitconverter.model;

import android.content.Context;

import com.migapro.wearunitconverter.R;

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
        String[] unitNamesArray = context.getResources().getStringArray(R.array.unit_names_length);
        String[] unitValuesArray = context.getResources().getStringArray(R.array.unit_values_length);
        mUnitList = new UnitList(unitNamesArray, unitValuesArray);
    }

    public void convertNumber() {
        double numberFrom = 0.0;

        try {
            numberFrom = Double.parseDouble(mNumFrom);
        } catch (NumberFormatException nfe) {
            numberFrom = 0.0; //TODO Temporary
        }

        double base = numberFrom * mUnitList.getUnitValue(mUnitFrom);
        double converted = base / mUnitList.getUnitValue(mUnitTo);
        mNumTo = String.valueOf(converted);
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

    public void setNumTo(String mNumTo) {
        this.mNumTo = mNumTo;
    }

    public void setUnitTo(int mUnitTo) {
        this.mUnitTo = mUnitTo;
    }

    public void setMeasurementType(int measurementType) {
        mMeasurementType = measurementType;
    }
}

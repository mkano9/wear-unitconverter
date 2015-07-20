package com.migapro.wearunitconverter.model;

import android.content.Context;

import com.migapro.wearunitconverter.model.arithmetic.Arithmetic;
import com.migapro.wearunitconverter.model.arithmetic.Length;
import com.migapro.wearunitconverter.utility.Constants;

public class Conversion {

    private String mNumFrom;
    private String mNumTo;
    private int mUnitToIndex;
    private int mUnitFromIndex;
    private int mMeasurementType;
    private String[] mUnitNamesArray;
    private Arithmetic mArithmetic;

    public Conversion(Context context) {
        mNumFrom = "0";
        mNumTo = "0";
        loadUnitsList(context);
    }

    public void loadUnitsList(Context context) {
        mUnitToIndex = 0;
        mUnitFromIndex = 0;

        mUnitNamesArray = context.getResources()
                .getStringArray(Constants.UNIT_NAMES_RESOURCE_IDS[mMeasurementType]);
        mArithmetic = new Length(context, mMeasurementType);
    }

    public void convertNumber() {
        mNumTo = mArithmetic.convert(this);
    }

    public String getNumFrom() {
        return mNumFrom;
    }

    public String getUnitFromName() {
        return mUnitNamesArray[mUnitFromIndex];
    }

    public int getUnitFromIndex() {
        return mUnitFromIndex;
    }

    public String getNumTo() {
        return mNumTo;
    }

    public String getUnitToName() {
        return mUnitNamesArray[mUnitToIndex];
    }

    public int getUnitToIndex() {
        return mUnitToIndex;
    }

    public String[] getUnitNamesList() {
        return mUnitNamesArray;
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

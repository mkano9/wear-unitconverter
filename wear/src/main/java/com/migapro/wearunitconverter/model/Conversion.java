package com.migapro.wearunitconverter.model;

import android.content.Context;

import com.migapro.wearunitconverter.model.arithmetic.Arithmetic;
import com.migapro.wearunitconverter.model.arithmetic.Length;
import com.migapro.wearunitconverter.utility.Constants;

public class Conversion {

    private Input mInput;
    private int mMeasurementType;
    private String[] mUnitNamesArray;
    private Arithmetic mArithmetic;

    public Conversion(Context context) {
        mInput = new Input();
        loadUnitsList(context);
    }

    public void loadUnitsList(Context context) {
        mInput.initUnitsIndex();

        mUnitNamesArray = context.getResources()
                .getStringArray(Constants.UNIT_NAMES_RESOURCE_IDS[mMeasurementType]);
        mArithmetic = new Length(context, mMeasurementType);
    }

    public void convertNumber() {
        mInput.setNumTo(mArithmetic.convert(mInput));
    }

    public String getNumFrom() {
        return mInput.getNumFrom();
    }

    public String getUnitFromName() {
        return mUnitNamesArray[mInput.getUnitFromIndex()];
    }

    public String getNumTo() {
        return mInput.getNumTo();
    }

    public String getUnitToName() {
        return mUnitNamesArray[mInput.getUnitToIndex()];
    }

    public String[] getUnitNamesList() {
        return mUnitNamesArray;
    }

    public void setNumFrom(String numFrom) {
        mInput.setNumFrom(numFrom);
    }

    public void setUnitFrom(int unitFrom) {
        mInput.setUnitFromIndex(unitFrom);
    }

    public void setUnitTo(int unitTo) {
        mInput.setUnitToIndex(unitTo);
    }

    public void setMeasurementType(int measurementType) {
        mMeasurementType = measurementType;
    }
}

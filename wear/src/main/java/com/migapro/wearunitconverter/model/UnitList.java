package com.migapro.wearunitconverter.model;

public class UnitList {

    private String[] mUnitNames;
    private String[] mUnitValues;

    public UnitList(String[] unitNames, String[] unitValues) {
        mUnitNames = unitNames;
        mUnitValues = unitValues;
    }

    public String[] getUnitNames() {
        return mUnitNames;
    }

    public String[] getUnitValues() {
        return mUnitValues;
    }

    public String getUnitValue(int position) {
        return mUnitValues[position];
    }

    public void setUnitNames(String[] unitNames) {
        mUnitNames = unitNames;
    }

    public void setUnitValues(String[] unitValues) {
        mUnitValues = unitValues;
    }
}

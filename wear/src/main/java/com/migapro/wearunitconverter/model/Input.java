package com.migapro.wearunitconverter.model;

public class Input {

    private String mNumFrom;
    private String mNumTo;
    private int mUnitToIndex;
    private int mUnitFromIndex;

    public Input() {
        mNumFrom = "0";
        mNumTo = "0";
    }

    public void initUnitsIndex() {
        mUnitToIndex = 0;
        mUnitFromIndex = 0;
    }

    public String getNumFrom() {
        return mNumFrom;
    }

    public void setNumFrom(String mNumFrom) {
        this.mNumFrom = mNumFrom;
    }

    public String getNumTo() {
        return mNumTo;
    }

    public void setNumTo(String mNumTo) {
        this.mNumTo = mNumTo;
    }

    public int getUnitToIndex() {
        return mUnitToIndex;
    }

    public void setUnitToIndex(int mUnitToIndex) {
        this.mUnitToIndex = mUnitToIndex;
    }

    public int getUnitFromIndex() {
        return mUnitFromIndex;
    }

    public void setUnitFromIndex(int mUnitFromIndex) {
        this.mUnitFromIndex = mUnitFromIndex;
    }
}

package com.migapro.wearunitconverter.model;

public class Conversion {

    private String mNumFrom;
    private String mUnitFrom;
    private String mNumTo;
    private String mUnitTo;

    public Conversion() {
        mNumFrom = "0";
        mNumTo = "0";
    }

    public void convertNumber() {
        // TODO
        // convert to base unit
        // convert to target unit
    }

    public String getNumFrom() {
        return mNumFrom;
    }

    public String getUnitFrom() {
        return mUnitFrom;
    }

    public String getNumTo() {
        return mNumTo;
    }

    public String getUnitTo() {
        return mUnitTo;
    }

    public void setNumFrom(String mNumFrom) {
        this.mNumFrom = mNumFrom;
    }

    public void setUnitFrom(String mUnitFrom) {
        this.mUnitFrom = mUnitFrom;
    }

    public void setNumTo(String mNumTo) {
        this.mNumTo = mNumTo;
    }

    public void setUnitTo(String mUnitTo) {
        this.mUnitTo = mUnitTo;
    }
}

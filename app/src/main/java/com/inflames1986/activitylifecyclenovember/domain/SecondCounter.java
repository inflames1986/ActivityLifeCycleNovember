package com.inflames1986.activitylifecyclenovember.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class SecondCounter implements Parcelable {

    private int value;

    private double secondValue;

    public SecondCounter() {

    }

    protected SecondCounter(Parcel in) {
        value = in.readInt();
        secondValue = in.readDouble();
    }

    public static final Creator<SecondCounter> CREATOR = new Creator<SecondCounter>() {
        @Override
        public SecondCounter createFromParcel(Parcel in) {
            return new SecondCounter(in);
        }

        @Override
        public SecondCounter[] newArray(int size) {
            return new SecondCounter[size];
        }
    };

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(value);
        dest.writeDouble(secondValue);
    }
}



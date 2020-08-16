package com.test.daggermitch.car;

import android.util.Log;

public class DieselEngine implements Engine {

    private static final String TAG = "Car";
    private int horsePower;

    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.i(TAG, "DieselEngine started. Horse Power is : " + horsePower);
    }
}

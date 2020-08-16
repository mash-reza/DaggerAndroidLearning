package com.test.daggermitch.car;

import android.util.Log;

import javax.inject.Inject;

public class Remote {

    private static final String TAG = "Car";

    @Inject
    public Remote() {
    }

    public void setListener(Car car) {
        Log.i(TAG, "Remote Connected.");
    }
}

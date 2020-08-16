package com.test.daggermitch;

import android.util.Log;

import javax.inject.Inject;

public class Tires {

    private static final String TAG = "Car";

    public void inflate(){
        Log.i(TAG, "Tires inflated");
    }
}

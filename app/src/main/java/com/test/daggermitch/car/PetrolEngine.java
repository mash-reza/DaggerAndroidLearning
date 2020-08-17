package com.test.daggermitch.car;

import android.util.Log;

import com.test.daggermitch.dagger.ActivityScope;

import javax.inject.Inject;
import javax.inject.Named;


@ActivityScope
public class PetrolEngine implements Engine {

    private static final String TAG = "Car";
    private int horsePower;
    private int engineCapacity;


    @Inject
    public PetrolEngine(@Named("horsePower")int horsePower,@Named("engineCapacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        Log.i(TAG, "PetrolEngine started. Horse Power is : " + horsePower + " Engine Capacity: " + engineCapacity);
    }
}

package com.test.daggermitch.car;

import android.util.Log;

import com.test.daggermitch.dagger.ActivityScope;

import javax.inject.Inject;
@ActivityScope
public class Car {

    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;
    private Driver driver;

    @Inject
    public Car(Engine engine, Wheels wheels, Driver driver) {
        this.engine = engine;
        this.wheels = wheels;
        this.driver = driver;
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        engine.start();
        Log.i(TAG, driver + " drives " + this);
    }
}

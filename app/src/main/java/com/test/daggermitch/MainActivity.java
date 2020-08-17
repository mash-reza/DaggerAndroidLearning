package com.test.daggermitch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.test.daggermitch.car.Car;
import com.test.daggermitch.car.DieselEngine;
import com.test.daggermitch.dagger.ActivityComponent;
import com.test.daggermitch.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Car car1;
    @Inject
    public Car car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent = ((MyApplication)getApplication()).getAppComponent()
                .activityComponentBuilder().engineCapacity(125).horsePower(20).build();
        activityComponent.inject(this);
        car1.drive();
        car2.drive();
    }
}
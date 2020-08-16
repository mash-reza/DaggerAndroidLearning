package com.test.daggermitch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.test.daggermitch.car.Car;
import com.test.daggermitch.dagger.CarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent = DaggerCarComponent.create();
        carComponent.inject(this);
        car.drive();
    }
}
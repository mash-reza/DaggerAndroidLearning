package com.test.daggermitch.dagger;

import com.test.daggermitch.car.DieselEngine;
import com.test.daggermitch.car.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

//    Driver getDriver();

    ActivityComponent activityComponent(DieselEngineModule dieselEngineModule);
}

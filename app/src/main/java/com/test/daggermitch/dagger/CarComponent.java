package com.test.daggermitch.dagger;

import com.test.daggermitch.MainActivity;

import dagger.Component;

@Component(modules = {DieselEngineModule.class, WheelsModule.class})
public interface CarComponent {

//    Car getCar();

    void inject(MainActivity mainActivity);
}

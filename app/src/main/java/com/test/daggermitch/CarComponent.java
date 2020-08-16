package com.test.daggermitch;

import dagger.Component;

@Component(modules = CarModule.class)
public interface CarComponent {

//    Car getCar();

    void inject(MainActivity mainActivity);
}

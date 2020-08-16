package com.test.daggermitch;

import dagger.Component;

@Component
public interface CarComponent {

//    Car getCar();

    void inject(MainActivity mainActivity);
}

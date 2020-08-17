package com.test.daggermitch.dagger;

import com.test.daggermitch.car.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {

    @Singleton
    @Provides
    public Driver provideDriver(){
        return new Driver();
    }
}

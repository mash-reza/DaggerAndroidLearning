package com.test.daggermitch.dagger;

import com.test.daggermitch.car.DieselEngine;
import com.test.daggermitch.car.Engine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @ActivityScope
    @Provides
    public int provideHorsePower(){
        return horsePower;
    }

    @ActivityScope
    @Provides
    public Engine provideEngine(DieselEngine engine) {
        return engine;
    }

    ;
}

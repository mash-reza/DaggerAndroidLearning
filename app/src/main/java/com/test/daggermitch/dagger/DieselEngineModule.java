package com.test.daggermitch.dagger;
import com.test.daggermitch.car.DieselEngine;
import com.test.daggermitch.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    public abstract Engine bindEngine(DieselEngine engine);
}

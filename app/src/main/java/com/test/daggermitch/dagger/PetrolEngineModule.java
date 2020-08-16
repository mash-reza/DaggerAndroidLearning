package com.test.daggermitch.dagger;

import com.test.daggermitch.car.Engine;
import com.test.daggermitch.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    public abstract Engine bindEngine(PetrolEngine engine);
}

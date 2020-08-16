package com.test.daggermitch;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {

    @Provides
    public Rims provideRims() {
        return new Rims();
    }

    @Provides
    public Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    public Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}

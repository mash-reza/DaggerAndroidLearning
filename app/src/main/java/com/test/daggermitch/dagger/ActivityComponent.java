package com.test.daggermitch.dagger;

import com.test.daggermitch.MainActivity;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {PetrolEngineModule.class, WheelsModule.class})
public interface ActivityComponent {

//    Car getCar();

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
        ActivityComponent build();


        @BindsInstance
        Builder horsePower(@Named("horsePower") int horsePower);


        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);

    }
}

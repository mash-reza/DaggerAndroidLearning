package com.test.daggermitch.dagger;

import com.test.daggermitch.MainActivity;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {PetrolEngineModule.class, WheelsModule.class})
public interface CarComponent {

//    Car getCar();

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{
        CarComponent build();


        @BindsInstance
        Builder horsePower(@Named("horsePower")int horsePower);


        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity")int engineCapacity);
    }
}

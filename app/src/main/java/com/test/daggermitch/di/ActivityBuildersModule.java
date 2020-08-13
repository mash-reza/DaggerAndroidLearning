package com.test.daggermitch.di;

import com.test.daggermitch.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    public abstract AuthActivity contributeAuthActivity();

    @Provides
    public static String getFuckerString(){
        return "Trump is MotherFucker";
    }
}

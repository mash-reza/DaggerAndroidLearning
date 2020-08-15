package com.test.daggermitch.di;

import com.test.daggermitch.di.auth.AuthModule;
import com.test.daggermitch.di.auth.AuthViewModelsModule;
import com.test.daggermitch.ui.auth.AuthActivity;
import com.test.daggermitch.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    public abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector
    public abstract MainActivity contributeMAinActivity();
}

package com.test.daggermitch.di;

import com.test.daggermitch.di.auth.AuthViewModelsModule;
import com.test.daggermitch.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class})
    public abstract AuthActivity contributeAuthActivity();
}

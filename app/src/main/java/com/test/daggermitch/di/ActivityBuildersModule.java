package com.test.daggermitch.di;

import com.test.daggermitch.di.auth.AuthModule;
import com.test.daggermitch.di.auth.AuthViewModelsModule;
import com.test.daggermitch.di.main.MainFragmentBuildersModule;
import com.test.daggermitch.di.main.MainModule;
import com.test.daggermitch.di.main.MainViewModelsModule;
import com.test.daggermitch.ui.auth.AuthActivity;
import com.test.daggermitch.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    public abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(modules = {MainModule.class, MainFragmentBuildersModule.class, MainViewModelsModule.class})
    public abstract MainActivity contributeMAinActivity();
}

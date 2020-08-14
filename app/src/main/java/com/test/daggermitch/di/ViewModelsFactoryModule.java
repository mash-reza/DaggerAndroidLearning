package com.test.daggermitch.di;

import androidx.lifecycle.ViewModelProvider;

import com.test.daggermitch.viewmodel.ViewModelProvidersFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelsFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(
            ViewModelProvidersFactory viewModelProvidersFactory);
}

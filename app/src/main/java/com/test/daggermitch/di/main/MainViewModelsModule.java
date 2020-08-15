package com.test.daggermitch.di.main;

import androidx.lifecycle.ViewModel;

import com.test.daggermitch.di.ViewModelKey;
import com.test.daggermitch.ui.main.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindsProfileViewModel(ProfileViewModel profileViewModel);
}

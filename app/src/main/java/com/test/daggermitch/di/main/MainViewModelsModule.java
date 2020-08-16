package com.test.daggermitch.di.main;

import androidx.lifecycle.ViewModel;

import com.test.daggermitch.di.ViewModelKey;
import com.test.daggermitch.ui.main.posts.PostViewModel;
import com.test.daggermitch.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindsProfileViewModel(ProfileViewModel profileViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindsPostsViewModel(PostViewModel postViewModel);
}

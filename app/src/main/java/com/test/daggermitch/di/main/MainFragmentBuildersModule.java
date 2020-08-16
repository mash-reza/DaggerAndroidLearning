package com.test.daggermitch.di.main;

import com.test.daggermitch.ui.main.posts.PostsFragment;
import com.test.daggermitch.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    public abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    public abstract PostsFragment postsFragment();
}

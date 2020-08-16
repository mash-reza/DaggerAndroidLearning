package com.test.daggermitch.di.main;

import com.test.daggermitch.network.main.MainApi;
import com.test.daggermitch.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @MainScope
    @Provides
    public static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

    @MainScope
    @Provides
    public static PostsRecyclerAdapter providePostRecyclerAdapter(){
        return new PostsRecyclerAdapter();
    }
}

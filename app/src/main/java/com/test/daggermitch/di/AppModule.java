package com.test.daggermitch.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Provides
    public static String getFuckerString(){
        return "Trump is MotherFucker";
    }

    @Provides
    public static boolean getApp(Application application){
        return application == null;
    }
}

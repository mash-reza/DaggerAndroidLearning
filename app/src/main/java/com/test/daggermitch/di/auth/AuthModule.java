package com.test.daggermitch.di.auth;

import com.test.daggermitch.network.auth.AuthApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    public static AuthApi provideRetrofitInstance(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

    @AuthScope
    @Provides
    @Named("auth")
    public static Object provideString(){
        return new Object();
    }
}

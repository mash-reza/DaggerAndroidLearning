package com.test.daggermitch.di.auth;

import com.test.daggermitch.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    public static AuthApi provideRetrofitInstance(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}

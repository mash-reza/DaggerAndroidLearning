package com.test.daggermitch;

import android.app.Application;

import com.test.daggermitch.dagger.ActivityComponent;
import com.test.daggermitch.dagger.AppComponent;
import com.test.daggermitch.dagger.DaggerAppComponent;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}

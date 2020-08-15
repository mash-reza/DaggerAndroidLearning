package com.test.daggermitch;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.test.daggermitch.ui.auth.AuthActivity;
import com.test.daggermitch.ui.auth.AuthViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        subscribeObservers();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, userAuthResource -> {
            if (userAuthResource != null) {
                switch (userAuthResource.status) {
                    case AUTHENTICATED: {
                        break;
                    }
                    case NOT_AUTHENTICATED: {
                        navigateToAuthActivity();
                        break;
                    }
                    case ERROR: {
                        break;
                    }
                    case LOADING: {
                        break;
                    }
                }
            }
        });
    }

    private void navigateToAuthActivity() {
        Intent intent = new Intent(this, AuthActivity.class);
        finish();
        startActivity(intent);
    }
}

package com.test.daggermitch.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.test.daggermitch.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";
    private AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: ViewModel is fucking trump's ass");
        Log.d(TAG, "AuthViewModel: retrofit object is null? " + (this.authApi == null));
    }
}

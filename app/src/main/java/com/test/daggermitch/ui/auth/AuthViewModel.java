package com.test.daggermitch.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.test.daggermitch.SessionManager;
import com.test.daggermitch.model.User;
import com.test.daggermitch.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;
    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
    }

    public void authenticateWithId(int userId) {
        sessionManager.authenticateWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(int userId) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId).subscribeOn(Schedulers.io())
                        .onErrorReturn(throwable -> {
                            User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser;
                        }).map(user -> {
                    if (user.getId() == -1)
                        return AuthResource.error("Error occurred. Fuck man!", user);
                    return AuthResource.authenticated(user);
                })
        );
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}

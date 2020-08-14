package com.test.daggermitch.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.test.daggermitch.model.User;
import com.test.daggermitch.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;
    private MediatorLiveData<User> authUser = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
    }

    public void authenticateWithId(int userId) {
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId).subscribeOn(Schedulers.io())
        );
        authUser.addSource(source, user -> {
            authUser.setValue(source.getValue());
            authUser.removeSource(source);
        });
    }

    public LiveData<User> observeUser() {
        return authUser;
    }
}

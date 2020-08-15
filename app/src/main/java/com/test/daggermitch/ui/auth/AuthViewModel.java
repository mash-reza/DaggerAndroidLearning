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
    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
    }

    public void authenticateWithId(int userId) {
        authUser.setValue(AuthResource.loading(null));
        final LiveData<AuthResource<User>> source = LiveDataReactiveStreams.fromPublisher(
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
        authUser.addSource(source, userAuthResource -> {
            authUser.setValue(source.getValue());
            authUser.removeSource(source);
        });
    }

    public LiveData<AuthResource<User>> observeUser() {
        return authUser;
    }
}

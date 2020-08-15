package com.test.daggermitch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.test.daggermitch.model.User;
import com.test.daggermitch.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {
    }

    public void authenticateWithId(LiveData<AuthResource<User>> source) {
        if (source != null) {
            authUser.setValue(AuthResource.loading(null));
            authUser.addSource(source, userAuthResource -> {
                authUser.setValue(source.getValue());
                authUser.removeSource(source);
            });
        }
    }

    public void logout() {
        authUser.setValue(AuthResource.logout());
    }

    public LiveData<AuthResource<User>> getAuthUser() {
        return authUser;
    }
}

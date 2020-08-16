package com.test.daggermitch.ui.main.profile;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.test.daggermitch.SessionManager;
import com.test.daggermitch.model.User;
import com.test.daggermitch.ui.auth.AuthResource;
import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private LiveData<AuthResource<User>> authenticatedUser;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        Log.d(TAG, "ProfileViewModel: profile view model is working... shit yes");
        authenticatedUser = sessionManager.getAuthUser();
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return authenticatedUser;
    }
}

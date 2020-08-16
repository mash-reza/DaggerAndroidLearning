package com.test.daggermitch.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.test.daggermitch.R;
import com.test.daggermitch.model.User;
import com.test.daggermitch.viewmodel.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private ViewModelProvidersFactory providersFactory;
    private ProfileViewModel profileViewModel;

    private TextView email;
    private TextView username;
    private TextView website;

    @Inject
    public ProfileFragment(ViewModelProvidersFactory viewModelProvidersFactory) {
        this.providersFactory = viewModelProvidersFactory;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        profileViewModel = new ViewModelProvider(this, providersFactory).get(ProfileViewModel.class);

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);

        profileViewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        profileViewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), userAuthResource -> {
            if (userAuthResource != null) {
                switch (userAuthResource.status) {
                    case AUTHENTICATED: {
                        showUserDetails(userAuthResource.data);
                        break;
                    }
                    case ERROR: {
                        showErrorDetails(userAuthResource.message);
                        break;
                    }
                }
            }
        });
    }

    private void showErrorDetails(String message) {
        email.setText(message);
    }

    private void showUserDetails(User data) {
        email.setText(data.getEmail());
        username.setText(data.getUsername());
        website.setText(data.getWebsite());
    }
}
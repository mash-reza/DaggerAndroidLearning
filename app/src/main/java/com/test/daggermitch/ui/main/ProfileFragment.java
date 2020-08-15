package com.test.daggermitch.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.test.daggermitch.R;
import com.test.daggermitch.di.ViewModelsFactoryModule;
import com.test.daggermitch.viewmodel.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private ViewModelProvidersFactory providersFactory;
    private ProfileViewModel profileViewModel;

    @Inject
    public ProfileFragment(ViewModelProvidersFactory viewModelProvidersFactory) {
        this.providersFactory = viewModelProvidersFactory;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(requireContext(), "Profile Fragment", Toast.LENGTH_SHORT).show();

        profileViewModel = new ViewModelProvider(this,providersFactory).get(ProfileViewModel.class);

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
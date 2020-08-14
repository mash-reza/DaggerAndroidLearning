package com.test.daggermitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.test.daggermitch.R;
import com.test.daggermitch.viewmodel.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    AuthViewModel authViewModel;

    @Inject
    public ViewModelProvidersFactory viewModelProvidersFactory;

    @Inject
    public Drawable logo;

    @Inject
    public RequestManager glideInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authViewModel = new ViewModelProvider(this,viewModelProvidersFactory)
                .get(AuthViewModel.class);
    }

    private void setLogo(){
        glideInstance.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }
}
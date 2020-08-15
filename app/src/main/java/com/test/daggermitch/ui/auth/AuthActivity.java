package com.test.daggermitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    private EditText userIdEditText;
    private Button userLoginButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userIdEditText = findViewById(R.id.user_id_input);
        userLoginButton = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progress_bar);

        authViewModel = new ViewModelProvider(this, viewModelProvidersFactory)
                .get(AuthViewModel.class);

        userLoginButton.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(userIdEditText.getText())) {
                authViewModel.authenticateWithId(Integer.parseInt(userIdEditText.getText().toString()));
            }
        });

        subscribeObservers();
    }

    private void subscribeObservers() {
        authViewModel.observeAuthState().observe(this, userAuthResource -> {
            if (userAuthResource != null) {
                switch (userAuthResource.status) {
                    case AUTHENTICATED: {
                        showProgressBar(false);
                        Log.d(TAG, "subscribeObservers: Auhtenticated Email:" + userAuthResource.data.getEmail());
                        break;
                    }
                    case NOT_AUTHENTICATED: {
                        showProgressBar(false);
                        break;
                    }
                    case ERROR: {
                        showProgressBar(false);
                        Toast.makeText(this, userAuthResource.message, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case LOADING: {
                        showProgressBar(true);
                        break;
                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.GONE);
    }

    private void setLogo() {
        glideInstance.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }
}
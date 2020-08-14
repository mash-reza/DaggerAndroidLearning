package com.test.daggermitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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

    private EditText userIdEditText;
    private Button userLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userIdEditText = findViewById(R.id.user_id_input);
        userLoginButton = findViewById(R.id.login_button);

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
        authViewModel.observeUser().observe(this, user -> {
            Log.d(TAG, "subscribeObservers: user login email is: " + user.getEmail());
        });
    }

    private void setLogo() {
        glideInstance.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }
}
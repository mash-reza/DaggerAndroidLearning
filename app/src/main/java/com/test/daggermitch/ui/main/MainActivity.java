package com.test.daggermitch.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import com.test.daggermitch.BaseActivity;
import com.test.daggermitch.R;
import com.test.daggermitch.ui.main.posts.PostsFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    PostsFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileFragment();
    }

    private void profileFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, profileFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_item_logout: {
                sessionManager.logout();
                return true;
            }
            default:
                return true;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_posts: {

                return true;
            }
            case R.id.nav_profile: {

                return true;
            }
        }
        return true;
    }
}
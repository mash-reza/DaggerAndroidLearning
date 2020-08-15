package com.test.daggermitch.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.daggermitch.BaseActivity;
import com.test.daggermitch.R;
import com.test.daggermitch.SessionManager;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileFragment();
    }

    private void profileFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,profileFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_menu_item_logout:{
                sessionManager.logout();
                return true;
            }
            default: return true;
        }
    }
}
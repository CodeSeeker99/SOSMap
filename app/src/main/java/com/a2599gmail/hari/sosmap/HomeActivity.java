package com.a2599gmail.hari.sosmap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    selectedFragment = MapFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, selectedFragment).commit();
                    return true;
                case R.id.navigation_add:
                    selectedFragment = AddRequestFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, selectedFragment).commit();
                    return true;
                case R.id.navigation_account:
                    selectedFragment = MyAccountFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, selectedFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    void loadDefaultFrag(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame, fragment).commit();
    }
}

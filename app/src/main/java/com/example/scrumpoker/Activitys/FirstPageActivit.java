package com.example.scrumpoker.Activitys;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.scrumpoker.Fragment.CreateFragment;
import com.example.scrumpoker.Fragment.ListFragment;
import com.example.scrumpoker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FirstPageActivit extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        bottomNavigationView = findViewById(R.id.bottomMenu);
        bottomNavigationView.setOnNavigationItemReselectedListener(navigationItemReselectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new com.example.scrumpoker.Fragment.ListFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemReselectedListener navigationItemReselectedListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.listMenu:
                            selectedFragment = new ListFragment();
                            break;
                        case R.id.createMenu:
                            selectedFragment = new CreateFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                }
            };



}

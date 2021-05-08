package com.example.wibugrams;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setControl();
//        setEvent();


    }

//    private void setControl() {
//        toolbar = findViewById(R.id.toolbar);
//        bottomNavigationView = findViewById(R.id.bottom_nav);
//        fabAdd = findViewById(R.id.fab);
//
//    }
//
//    private void setEvent() {
//        loadFragment(new HomeFragment());
//        toolbar.setTitle("Wibugrams");
//        bottomNavigationView.setBackground(null);
//        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
//
//        fabAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment = new AddNewFragment();
//                loadFragment(fragment);
//                toolbar.setTitle("Add New");
//            }
//        });
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment;
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        fragment = new HomeFragment();
//                        loadFragment(fragment);
//                        toolbar.setTitle("Wibugrams");
//                        return true;
//                    case R.id.search:
//                        fragment = new SearchFragment();
//                        loadFragment(fragment);
//                        toolbar.setTitle("Search");
//                        return true;
//                    case R.id.favorite:
//                        fragment = new FavoriteFragment();
//                        loadFragment(fragment);
//                        toolbar.setTitle("Favorite");
//                        return true;
//                    case R.id.profile:
//                        fragment = new ProfileFragment();
//                        loadFragment(fragment);
//                        toolbar.setTitle("Profile");
//                        return true;
//                }
//                return false;
//            }
//        });
//
//    }
//
//    private void loadFragment(Fragment fragment) {
//        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
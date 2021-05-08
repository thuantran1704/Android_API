package com.example.wibugrams.Home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.wibugrams.Fragments.HomeFragment;
import com.example.wibugrams.R;
import com.example.wibugrams.Utils.BottomNavigationViewHelper;
import com.example.wibugrams.Utils.SectionsPagerAdapter;
import com.example.wibugrams.Utils.UniversalImageLoader;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;
    private static final int HOME_FRAGMENT = 1;

    private Context mContext = HomeActivity.this;
    //widgets
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FrameLayout mFrameLayout;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting.");
//        mViewPager = findViewById(R.id.viewpager_container);
//        mFrameLayout = findViewById(R.id.container);
//        mRelativeLayout = findViewById(R.id.relLayoutParent);

        setupBottomNavigationView();
//        setupViewPager();
        initPhotoLoader();
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment()); //index 0
//        mViewPager = findViewById(R.id.container);
//        mViewPager.setAdapter(adapter);
//
//        mTabLayout = findViewById(R.id.tabs);
//        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initPhotoLoader() {
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }


    public void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: Home setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
        menuItem.setChecked(true);

    }


}

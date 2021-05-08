package com.example.wibugrams.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.wibugrams.R;
import com.example.wibugrams.Utils.BottomNavigationViewHelper;
import com.example.wibugrams.Utils.SectionsStatePagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


/**
 * Created by User on 6/4/2017.
 */

public class AccountSettingsActivity extends AppCompatActivity {
    private static final String TAG = "AccountSettingsActivity";
    private static final int ACTIVITY_NUM = 4;


    private Context mContext;
    public SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);

        setupBottomNavigationView();
        mContext = AccountSettingsActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relLayout1);
//
        setupSettingsList();
        setupBottomNavigationView();
        setupFragments();
//        getIncomingIntent();

        //setup the backarrow for navigating back to "ProfileActivity"
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //
//
//
//    private void getIncomingIntent(){
//        Intent intent = getIntent();
//
//        if(intent.hasExtra(getString(R.string.selected_image))
//                || intent.hasExtra(getString(R.string.selected_bitmap))){
//
//            //if there is an imageUrl attached as an extra, then it was chosen from the gallery/photo fragment
//            Log.d(TAG, "getIncomingIntent: New incoming imgUrl");
//            if(intent.getStringExtra(getString(R.string.return_to_fragment)).equals(getString(R.string.edit_profile_fragment))){
//
//                if(intent.hasExtra(getString(R.string.selected_image))){
//                    //set the new profile picture
//                    FirebaseMethods firebaseMethods = new FirebaseMethods(AccountSettingsActivity.this);
//                    firebaseMethods.uploadNewPhoto(getString(R.string.profile_photo), null, 0,
//                            intent.getStringExtra(getString(R.string.selected_image)), null);
//                }
//                else if(intent.hasExtra(getString(R.string.selected_bitmap))){
//                    //set the new profile picture
//                    FirebaseMethods firebaseMethods = new FirebaseMethods(AccountSettingsActivity.this);
//                    firebaseMethods.uploadNewPhoto(getString(R.string.profile_photo), null, 0,
//                            null,(Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap)));
//                }
//
//            }
//
//        }
//
//        if(intent.hasExtra(getString(R.string.calling_activity))){
//            Log.d(TAG, "getIncomingIntent: received incoming intent from " + getString(R.string.profile_activity));
//            setViewPager(pagerAdapter.getFragmentNumber(getString(R.string.edit_profile_fragment)));
//        }
//    }
//
    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile)); //fragment 0
        pagerAdapter.addFragment(new LogOutFragment(), getString(R.string.log_out)); //fragment 1
    }

    public void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment #: " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: initializing 'Account Settings' list.");
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile)); //fragment 0
        options.add(getString(R.string.log_out)); //fragement 1

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to fragment#: " + position);
                setViewPager(position);
            }
        });

    }


    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}

















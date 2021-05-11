package com.example.wibugrams.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.wibugrams.Adapter.PostAdapter;
import com.example.wibugrams.Adapter.ProfileAdapter;
import com.example.wibugrams.Common;
import com.example.wibugrams.Model.JSONResponsePost;
import com.example.wibugrams.Model.Post;
import com.example.wibugrams.R;
import com.example.wibugrams.Retrofit.ApiInterface;
import com.example.wibugrams.Utils.BottomNavigationViewHelper;
import com.example.wibugrams.Utils.GridImageAdapter;
import com.example.wibugrams.Utils.SectionsStatePagerAdapter;
import com.example.wibugrams.Utils.UniversalImageLoader;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    ProfileAdapter viewPagerAdapter = null;
    private ArrayList<Post> posts;
    final String key = "VSBG";
    String userId="";

    private Context mContext = ProfileActivity.this;
    private CircleImageView profilePhoto;
    private ImageView profileSettings;
    private Toolbar toolbar;
    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager mViewpager;
    private ProgressBar progressBar;

    private GridView gridViewProfile;

    ApiInterface service;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mViewpager = findViewById(R.id.container);
        profilePhoto = findViewById(R.id.profile_photo);

        gridViewProfile = findViewById(R.id.gridView);

        Log.d(TAG, "onCreate: starting.");

        service = Common.getGsonService();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            userId = bundle.getString("UserID");
            Toast.makeText(this, "Show value: " + userId, Toast.LENGTH_SHORT).show();

            loadProfile(userId);
        }

        /*if(!userId.isEmpty()) {
            loadProfile(userId);*/
        /*if(getIntent() != null){
           userId  = getIntent().getStringExtra("UserID");

        }
        if(!userId.isEmpty() && userId != null){
            loadProfile(userId);
        }*/

        setupBottomNavigationView();
        //setupToolbar();
        //setupProfilePhoto();
        //tempGridSetup();

    }

    private void loadProfile(String userId) {

        Log.e("ccc","sadad"+userId);
        //userId  = getIntent().getExtras().getString("UserID");
        service.getPostUserID(key,userId).enqueue(new Callback<JSONResponsePost>() {
            @Override
            public void onResponse(Call<JSONResponsePost> call, Response<JSONResponsePost> response) {
                JSONResponsePost jsonResponsePost = response.body();
                if (jsonResponsePost.getData() == null) {
                    Toast.makeText(getBaseContext(), "This Profile does not has Post", Toast.LENGTH_SHORT).show();
                    return;
                }
                posts = new ArrayList<>(Arrays.asList(jsonResponsePost.getData()));
                Log.e("aaaa","brvdfvdv"+jsonResponsePost.getStatus());
                //viết profile adapter để set giao diện cho 1 tấm hình hiển thị ở layout center profile...trong profile adapter thì row = inflater.inflate(R.layout.profile_item_image, parent, false);
                viewPagerAdapter = new ProfileAdapter(getBaseContext(), R.layout.layout_center_profile, posts);
                gridViewProfile.setAdapter(viewPagerAdapter);
                viewPagerAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<JSONResponsePost> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Erro : "+ t, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setupToolbar() {
        toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        profileSettings = findViewById(R.id.profile_settings);
        profileSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

    }
    private void tempGridSetup(){
        ArrayList<String> imgUrls= new ArrayList<>();
        imgUrls.add("https://i.pinimg.com/564x/22/66/b1/2266b1c5a2f07fceb92729f0e07049af.jpg");
        imgUrls.add("https://i.pinimg.com/564x/aa/31/b3/aa31b373b6451b238ff9f50ea8d210df.jpg");
        imgUrls.add("https://i.pinimg.com/564x/92/6b/cd/926bcd1d4fd0c06f8f11faa09dbe1fd8.jpg");
        imgUrls.add("https://i.pinimg.com/564x/d9/ed/60/d9ed60fa07e1a1d67392c62c153c9773.jpg");
        imgUrls.add("https://i.pinimg.com/564x/64/b7/57/64b757268ca1f4ae13e54837c6f9685a.jpg");
        imgUrls.add("https://i.pinimg.com/564x/3e/af/be/3eafbe4d4f4e9ead81a79e469f722222.jpg");
        imgUrls.add("https://i.pinimg.com/564x/e0/cb/28/e0cb283fff400251863db25de74b36d8.jpg");
        imgUrls.add("https://i.pinimg.com/564x/28/56/d4/2856d41c68fd2edce9ea093fa932faff.jpg");
        imgUrls.add("https://i.pinimg.com/564x/0f/dc/56/0fdc569c9fabb7fee131e60a71b30c75.jpg");
        imgUrls.add("https://i.pinimg.com/564x/0f/78/ba/0f78ba56d5fa3e581776ca470dab7fa3.jpg");
        imgUrls.add("https://i.pinimg.com/564x/03/04/ce/0304ce47212dbcb6ffe190e9de97fdcb.jpg");
        imgUrls.add("https://i.pinimg.com/564x/9d/8c/ca/9d8cca78aafe3c64627afc8da72a5852.jpg");

        setupImageGrid(imgUrls);
    }
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);
        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview,"", imgURLs);
        gridView.setAdapter(adapter);
    }
    private void setupProfilePhoto() {
        String photoURL = "www.nordvpn.com/wp-content/uploads/android-vs-ios_1200x675.jpg";
        UniversalImageLoader.setImage(photoURL, profilePhoto, null, "https://");

    }

//    private void setupActivityWidgets() {
//        progressBar = findViewById(R.id.progressBar);
//
//    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}

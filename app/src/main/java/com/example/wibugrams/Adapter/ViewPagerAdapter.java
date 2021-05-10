package com.example.wibugrams.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.wibugrams.Fragments.AddNewFragment;
import com.example.wibugrams.Fragments.FavoriteFragment;
import com.example.wibugrams.Fragments.HomeFragment;
import com.example.wibugrams.Fragments.LoginFragment;
import com.example.wibugrams.Fragments.ProfileFragment;
import com.example.wibugrams.Fragments.SearchFragment;
import com.example.wibugrams.Fragments.SignUpFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new AddNewFragment();
            case 3:
                return new FavoriteFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Home";
                break;
            case 1:
                title = "Search";
            case 2:
                title = "AddPost";
            case 3:
                title = "Favorite";
            case 4:
                title = "Profile";
                break;
        }
        return title;
    }
}

package com.example.tailoredtech.smartparking.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.Constants;
import com.example.tailoredtech.smartparking.fragments.BookSlotFragment;
import com.example.tailoredtech.smartparking.fragments.MoreFragment;
import com.example.tailoredtech.smartparking.fragments.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class HomeActivity extends AppCompatActivity {

    private BottomBar bottomBar;
    private BookSlotFragment bookSlotFragment;
    private MoreFragment moreFragment;
    private ProfileFragment profileFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setBottomBar(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
    }

    private void setBottomBar(Bundle savedInstanceState) {
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.useFixedMode();
        bottomBar.setTypeFace(Constants.OPEN_SANS_REGULAR);
        bottomBar.setActiveTabColor(ContextCompat.getColor(this, R.color.colorPrimary));
        bottomBar.setItems(R.menu.menu_bottom_bar);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                onBottomMenuClick(menuItemId);
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bottomBar.setElevation(15f);
        }
    }

    private void onBottomMenuClick(int menuItemId) {
        Fragment fragment = getFragmentFromPosition(menuItemId);
        attachFragment(fragment);
        Toast.makeText(this,"on menu clicked: "+menuItemId,Toast.LENGTH_SHORT).show();
    }

    private void attachFragment(Fragment fragment) {
        String TAG = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    private Fragment getFragmentFromPosition(int position) {
        Fragment fragment = null;
        switch (position) {
            case R.id.bottom_menu_click:
                fragment = initBookSlotFragment();
                break;
            case R.id.bottom_menu_mirror:
                fragment = initMirrorFragment();
                break;
            case R.id.bottom_menu_profile:
                fragment = initProfileFragment();
                break;
            case R.id.bottom_menu_more:
                fragment = initMoreFragment();
                break;
        }
        return fragment;
    }

    private Fragment initBookSlotFragment(){
        if (bookSlotFragment == null) {
            bookSlotFragment = new BookSlotFragment();
        }
        return bookSlotFragment;
    }

    private Fragment initMirrorFragment(){
        if (bookSlotFragment == null) {
            bookSlotFragment = new BookSlotFragment();
        }
        return bookSlotFragment;
    }

    private Fragment initProfileFragment(){
        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
        }
        return profileFragment;
    }

    private Fragment initMoreFragment(){
        if (moreFragment == null) {
            moreFragment = new MoreFragment();
        }
        return moreFragment;
    }
}

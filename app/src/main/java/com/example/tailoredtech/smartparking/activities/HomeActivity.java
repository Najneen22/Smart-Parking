package com.example.tailoredtech.smartparking.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.Constants;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class HomeActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBottomBar(savedInstanceState);
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
        /*bottomBar.setItemsFromMenu(R.menu.menu_bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                onBottomMenuClick(menuItemId);
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
            }
        });*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bottomBar.setElevation(15f);
        }
    }

    private void onBottomMenuClick(int menuItemId) {
       /* Fragment fragment = getFragmentFromPosition(menuItemId);
        attachFragment(fragment);*/
        Toast.makeText(this,"on menu clicked: "+menuItemId,Toast.LENGTH_SHORT).show();
    }
}

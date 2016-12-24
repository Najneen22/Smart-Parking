package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.Utils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actvitiy);

        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        /*if(Utils.isInternetConnected(this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                *//* Create an Intent that will start the Menu-Activity. *//*
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    Intent mainIntent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, 1000);
        }
        else {
            Toast.makeText(this, getString(R.string.no_internet_msg),Toast.LENGTH_SHORT).show();
        }*/
    }
}

package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.tailoredtech.smartparking.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actvitiy);

//        if(Utils.isInternetConnected(this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    (SplashActivity.this).finish();
                }
            }, 1000);
       /* }
        else {
            Toast.makeText(this, getString(R.string.no_internet_msg),Toast.LENGTH_SHORT).show();
        }*/
    }
}

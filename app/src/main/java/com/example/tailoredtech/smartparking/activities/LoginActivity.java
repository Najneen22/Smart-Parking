package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tailoredtech.smartparking.R;
import com.viewpagerindicator.CirclePageIndicator;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn, btnFbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ViewPager mViewPager = (ViewPager)findViewById(R.id.viewpager);
        CirclePageIndicator mPageIndicator = (CirclePageIndicator) findViewById(R.id.pageIndicator);
        mPageIndicator.setViewPager(mViewPager);

        btnSignIn= (Button) findViewById(R.id.btn_sign_in);
        btnFbLogin= (Button) findViewById(R.id.btn_fb_login);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MobileLoginActivity.class));
            }
        });
        btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });
    }


}


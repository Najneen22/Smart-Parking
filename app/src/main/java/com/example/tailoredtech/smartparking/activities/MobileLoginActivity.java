package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tailoredtech.smartparking.R;

public class MobileLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_login);
    }

    public void submitClick()
    {
        startActivity(new Intent(this,HomeActivity.class));
    }
}

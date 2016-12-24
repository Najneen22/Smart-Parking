package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tailoredtech.smartparking.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signInClick()
    {
        startActivity(new Intent(this,MobileLoginActivity.class));
    }

    public void fbClick()
    {
        startActivity(new Intent(this,HomeActivity.class));
    }
}


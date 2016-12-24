package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tailoredtech.smartparking.R;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn, btnFbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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


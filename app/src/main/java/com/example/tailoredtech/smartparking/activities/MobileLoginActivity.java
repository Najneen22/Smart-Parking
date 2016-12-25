package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.widget.AppButton;

public class MobileLoginActivity extends AppCompatActivity {

    AppButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_login);
        btnSubmit= (AppButton) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MobileLoginActivity.this,HomeActivity.class));
            }
        });

    }


}

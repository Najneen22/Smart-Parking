package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.widget.AppEditText;

public class UserDetailsActivity extends AppCompatActivity {

    AppEditText edName, edVehicleNumeber, edLisenceNumebr;
    boolean shouldEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Enter Your Details");

        edName = (AppEditText) findViewById(R.id.user_name);
        edVehicleNumeber = (AppEditText) findViewById(R.id.vehicle_number);
        edLisenceNumebr = (AppEditText) findViewById(R.id.license_number);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edName.getText().toString().trim().length() > 0 &&
                        edVehicleNumeber.getText().toString().length() > 0 &&
                        edLisenceNumebr.getText().toString().length() > 0){
                    shouldEnabled = true;
                }
                else
                    shouldEnabled = false;
            }
        };
        edName.addTextChangedListener(textWatcher);
        edVehicleNumeber.addTextChangedListener(textWatcher);
        edLisenceNumebr.addTextChangedListener(textWatcher);
    }

    public void submitDetails(View view){
        if (shouldEnabled){
            /*User user = new User();
            user.setUserName(edName.getText().toString().trim());
            user.setLicenseId(edLisenceNumebr.getText().toString().trim());
            user.setVehicleNumber(edVehicleNumeber.getText().toString().trim());
            DBHelper.addUser(user);*/
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        else {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }

    }
}

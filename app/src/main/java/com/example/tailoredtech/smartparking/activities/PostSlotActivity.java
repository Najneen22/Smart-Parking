package com.example.tailoredtech.smartparking.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.Utils;

public class PostSlotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_slot);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Post a Slot");

        TextView userName = (TextView) findViewById(R.id.txt_user_name);
        EditText edMessage = (EditText) findViewById(R.id.ed_message);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioVehicle);

        final TextView parkingFare = (TextView) findViewById(R.id.txt_parking_fare);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                if(id == R.id.radio2wheeler)
                    parkingFare.setText("Rs.10");
                else
                    parkingFare.setText("Rs. 20");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void uploadPhoto(View view){
        Utils.showWarningAlertWithPositiveBtn(this, "Please upload parking slot's photo here");
    }

    public void uploadIdentityImage(View view){
        Utils.showWarningAlertWithPositiveBtn(this, "Please upload your identity card picture");
    }

    public void submitDetails(View view){
        finish();
    }
}

package com.example.tailoredtech.smartparking.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.Utils;

public class PostSlotActivity extends AppCompatActivity {

    private boolean isIdentityProofEntered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_slot);
        TextView userName = (TextView) findViewById(R.id.txt_user_name);
        final EditText edIdentityProof = (EditText) findViewById(R.id.ed_id_proof);
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
                    parkingFare.setText("rs. 20");
            }
        });

        edIdentityProof.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isIdentityProofEntered = edIdentityProof.getText().toString().trim().length() > 0;
            }
        });
    }

    public void uploadPhoto(View view){
        Utils.showWarningAlertWithPositiveBtn(this, "Please upload parking slot's photo here");
    }

    public void submitDetails(View view){
        if(isIdentityProofEntered) {
            //TODO add this slot place to DB
            finish();
        }
        else {
            Toast.makeText(this,"Please add your identity proof", Toast.LENGTH_SHORT).show();
        }
    }
}

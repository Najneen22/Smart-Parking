package com.example.tailoredtech.smartparking.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;

import java.util.Date;

public class PaymentActivity extends AppCompatActivity {

    TextView txtSlotNo;
    TextView txtRceiptNo;
    LinearLayout layout_reg;
    ImageView imgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        txtRceiptNo= (TextView) findViewById(R.id.receipt_no);
        txtSlotNo= (TextView) findViewById(R.id.slot_no);
        layout_reg= (LinearLayout) findViewById(R.id.layout_reg);
        imgClose= (ImageView) findViewById(R.id.img_close);

        if(getIntent().hasExtra("pos")){
            layout_reg.setVisibility(View.VISIBLE);
            txtSlotNo.setText(String.valueOf(getIntent().getStringExtra("pos")));
        }
        else
        {
            layout_reg.setVisibility(View.GONE);
        }
        txtRceiptNo.setText(String.valueOf(new Date().getTime()));
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PaymentActivity.this,HomeActivity.class));
        super.onBackPressed();
    }
}

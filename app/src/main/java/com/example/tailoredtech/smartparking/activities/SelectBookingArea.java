package com.example.tailoredtech.smartparking.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.DepthPageTransformer;
import com.example.tailoredtech.smartparking.adapter.BookAreaPagerAdapter;

public class SelectBookingArea extends AppCompatActivity {

    private ViewPager pager;
    private BookAreaPagerAdapter bookAreaPagerAdapter;
    private TextView txtTotalFloors,txtCurrentFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_booking_area);
        pager= (ViewPager) findViewById(R.id.viewpager_booking_areas);
        txtTotalFloors= (TextView) findViewById(R.id.txt_total_floors);
        txtCurrentFloor= (TextView) findViewById(R.id.txt_current_floor);
        bookAreaPagerAdapter=new BookAreaPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(bookAreaPagerAdapter);
        pager.setPageTransformer(true,new DepthPageTransformer());
        txtTotalFloors.setText(String.valueOf(bookAreaPagerAdapter.getCount()));
        txtCurrentFloor.setText(String.valueOf(1));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txtCurrentFloor.setText(String.valueOf(position+1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

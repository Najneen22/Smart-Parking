package com.example.tailoredtech.smartparking.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.Utils.DepthPageTransformer;
import com.example.tailoredtech.smartparking.adapter.BookAreaPagerAdapter;
import com.example.tailoredtech.smartparking.widget.AppTextView;

public class SelectBookingArea extends AppCompatActivity {

    private ViewPager pager;
    private BookAreaPagerAdapter bookAreaPagerAdapter;
    private AppTextView txtTotalFloors,txtCurrentFloor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_booking_area);
        toolbar= (Toolbar) findViewById(R.id.app_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pick your spot");
        pager= (ViewPager) findViewById(R.id.viewpager_booking_areas);
        txtTotalFloors= (AppTextView) findViewById(R.id.txt_total_floors);
        txtCurrentFloor= (AppTextView) findViewById(R.id.txt_current_floor);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return true;
    }
}

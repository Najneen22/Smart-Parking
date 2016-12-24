package com.example.tailoredtech.smartparking.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tailoredtech.smartparking.fragments.BookAreaFragment;

/**
 * Created by Daniyal on 12/25/2016.
 */

public class BookAreaPagerAdapter extends FragmentStatePagerAdapter {

    public BookAreaPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new BookAreaFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}

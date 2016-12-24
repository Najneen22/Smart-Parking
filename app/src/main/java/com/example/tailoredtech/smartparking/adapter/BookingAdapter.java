package com.example.tailoredtech.smartparking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.models.Parking;

import java.util.ArrayList;

/**
 * Created by Daniyal on 12/25/2016.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyBookingViewHolder>{

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Parking> parkingArrayList;

    public BookingAdapter(Context mContext) {
        this.mContext = mContext;
        this.mInflator=LayoutInflater.from(mContext);
    }

    @Override
    public MyBookingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflator.inflate(R.layout.list_item_book,parent,false);
        return new MyBookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyBookingViewHolder extends RecyclerView.ViewHolder {
        public MyBookingViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void updateList(ArrayList<Parking> parkings)
    {
        this.parkingArrayList=parkings;
        notifyDataSetChanged();
    }
}

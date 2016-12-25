package com.example.tailoredtech.smartparking.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.models.Parking;

import java.util.ArrayList;

/**
 * Created by Daniyal on 12/25/2016.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyBookingViewHolder> {

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Parking> parkingArrayList;
    private IBook iBook;

    public BookingAdapter(Context mContext) {
        this.mContext = mContext;
        this.mInflator = LayoutInflater.from(mContext);
    }

    @Override
    public MyBookingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflator.inflate(R.layout.list_item_book, parent, false);
        return new MyBookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookingViewHolder holder, int position) {
        if(position%2==0)
        {
            holder.imgArrow.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorPrimary));
        }
        else
        {
            holder.imgArrow.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorPrimaryDark));
        }
        holder.txtCarFare.setText(mContext.getString(R.string.price, 25));
        holder.txtBikeFare.setText(mContext.getString(R.string.price, 10));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyBookingViewHolder extends RecyclerView.ViewHolder {

        TextView txtCarFare, txtBikeFare;
        ImageView imgArrow;

        public MyBookingViewHolder(View itemView) {
            super(itemView);
            txtCarFare= (TextView) itemView.findViewById(R.id.txt_fare_car);
            txtBikeFare= (TextView) itemView.findViewById(R.id.txt_fare_bike);
            imgArrow= (ImageView) itemView.findViewById(R.id.img_proceed);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iBook.onItemClick(getLayoutPosition());
                }
            });
        }
    }

    public void updateList(ArrayList<Parking> parkings) {
        this.parkingArrayList = parkings;
        notifyDataSetChanged();
    }

    public interface IBook {
        void onItemClick(int position);
    }

    public void setListener(IBook iBook) {
        this.iBook = iBook;
    }
}

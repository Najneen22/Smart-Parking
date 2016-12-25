package com.example.tailoredtech.smartparking.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.models.Parking;
import com.example.tailoredtech.smartparking.widget.AppTextView;
import com.squareup.picasso.Picasso;

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
        this.parkingArrayList=new ArrayList<>();
    }

    @Override
    public MyBookingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflator.inflate(R.layout.list_item_book, parent, false);
        return new MyBookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookingViewHolder holder, int position) {
        Parking parking=parkingArrayList.get(position);
        if(!parking.getIsavail())
        {
            holder.imgArrow.setBackgroundColor(ContextCompat.getColor(mContext,R.color.red));
        }
        else
        {
            holder.imgArrow.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorPrimaryDark));
        }
        holder.txtCarFare.setText(mContext.getString(R.string.price, parking.getCarfare()));
        holder.txtBikeFare.setText(mContext.getString(R.string.price, parking.getBikefare()));
        Picasso.with(mContext).load(parking.getPImg()).into(holder.imgParking);
        holder.txtParkingName.setText(parking.getPname());
        holder.txtMode.setText(parking.getMode());
        if(parking.getIsPremium())
        {
            holder.imgPremium.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.imgPremium.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return parkingArrayList.size();
    }

    public class MyBookingViewHolder extends RecyclerView.ViewHolder {

        AppTextView txtCarFare, txtBikeFare, txtParkingName, txtMode;
        ImageView imgArrow,imgParking,imgPremium;

        public MyBookingViewHolder(View itemView) {
            super(itemView);
            imgPremium= (ImageView) itemView.findViewById(R.id.img_premium);
            txtCarFare= (AppTextView) itemView.findViewById(R.id.txt_fare_car);
            txtBikeFare= (AppTextView) itemView.findViewById(R.id.txt_fare_bike);
            imgArrow= (ImageView) itemView.findViewById(R.id.img_proceed);
            txtParkingName= (AppTextView) itemView.findViewById(R.id.txt_p_name);
            txtMode= (AppTextView) itemView.findViewById(R.id.txt_rental_type);
            imgParking= (ImageView) itemView.findViewById(R.id.img_parking);
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

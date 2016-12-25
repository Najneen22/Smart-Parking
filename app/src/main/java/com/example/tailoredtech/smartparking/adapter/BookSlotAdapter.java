package com.example.tailoredtech.smartparking.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.activities.PaymentActivity;
import com.example.tailoredtech.smartparking.widget.AppButton;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Daniyal on 12/25/2016.
 */

public class BookSlotAdapter extends RecyclerView.Adapter<BookSlotAdapter.MyBookSlotHolder>{

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Integer> reservedSlots=new ArrayList<>(Arrays.asList(1,68,24));
    private ArrayList<Integer> bookedSlots=new ArrayList<>(Arrays.asList(12,5,6,7,8,9,10,11,
            12,25,2945,46,47,50));
    private int selectedSlot=-1;

    public BookSlotAdapter(Context mContext) {
        this.mContext = mContext;
        this.mInflator=LayoutInflater.from(mContext);
    }

    @Override
    public MyBookSlotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflator.inflate(R.layout.listitem_book_slot,parent,false);
        return new MyBookSlotHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookSlotHolder holder, int position) {
        holder.btnSlot.setText(String.valueOf(position));
        if(reservedSlots.contains(position))
        {
            holder.btnSlot.setBackgroundResource(R.drawable.reserved);
        }
        else if(bookedSlots.contains(position))
        {
            holder.btnSlot.setBackgroundResource(R.drawable.booked);
        }
        else if(selectedSlot==position)
        {
            holder.btnSlot.setBackgroundResource(R.drawable.selected);
        }
        else {
            holder.btnSlot.setBackground(ContextCompat.getDrawable(mContext,R.drawable.in_selection));
        }

    }


    @Override
    public int getItemCount() {
        return 100;
    }

    class MyBookSlotHolder extends RecyclerView.ViewHolder {
        private AppButton btnSlot;
        public MyBookSlotHolder(View itemView) {
            super(itemView);
            btnSlot = (AppButton) itemView.findViewById(R.id.btn_slot);
            btnSlot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getLayoutPosition();
                    selectedSlot=pos;
                    if(!reservedSlots.contains(pos)|| bookedSlots.contains(pos))
                    {
                        Intent intent=new Intent(mContext, PaymentActivity.class);
                        intent.putExtra("Pos",pos);
                        mContext.startActivity(intent);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }
}

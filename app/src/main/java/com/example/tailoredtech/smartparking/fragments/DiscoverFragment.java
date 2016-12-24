package com.example.tailoredtech.smartparking.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.activities.SelectBookingArea;
import com.example.tailoredtech.smartparking.adapter.BookingAdapter;

public class DiscoverFragment extends Fragment {

    public DiscoverFragment() {}

    private RecyclerView parkingListView;
    private BookingAdapter bookingAdapter;

    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_slot, container, false);
        parkingListView = (RecyclerView) view.findViewById(R.id.parking_list);
        bookingAdapter = new BookingAdapter(getActivity());
        parkingListView.setAdapter(bookingAdapter);
        parkingListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bookingAdapter.setListener(new BookingAdapter.IBook() {
            @Override
            public void onItemClick(int position) {
                if (position % 2 == 0) {
                    startActivity(new Intent(getActivity(), SelectBookingArea.class));
                } else {
                    startActivity(new Intent(getActivity(), SelectBookingArea.class));
                }
            }
        });
        return view;
    }
}

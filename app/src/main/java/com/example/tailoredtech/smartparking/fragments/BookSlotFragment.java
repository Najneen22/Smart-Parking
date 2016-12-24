package com.example.tailoredtech.smartparking.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;

public class BookSlotFragment extends Fragment {

    public BookSlotFragment() {
        // Required empty public constructor
    }

    public static BookSlotFragment newInstance(String param1, String param2) {
        BookSlotFragment fragment = new BookSlotFragment();
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
        return inflater.inflate(R.layout.fragment_book_slot, container, false);
    }


}

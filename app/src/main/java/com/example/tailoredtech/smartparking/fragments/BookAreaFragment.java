package com.example.tailoredtech.smartparking.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.adapter.BookSlotAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookAreaFragment extends Fragment {

    private RecyclerView bookSlotList;
    private BookSlotAdapter bookSlotAdapter;

    public BookAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_book_area, container, false);
        bookSlotList= (RecyclerView) view.findViewById(R.id.booking_area_list);
        bookSlotAdapter=new BookSlotAdapter(getActivity());
        bookSlotList.setAdapter(bookSlotAdapter);
        bookSlotList.setLayoutManager(new GridLayoutManager(getActivity(),7));
        return view;
    }

}

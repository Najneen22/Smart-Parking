package com.example.tailoredtech.smartparking.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.TabBarCommunicator;
import com.example.tailoredtech.smartparking.activities.HomeActivity;


public class FavouritesFragment extends Fragment {

    public FavouritesFragment() {
        // Required empty public constructor
    }

    public static FavouritesFragment newInstance(String param1, String param2) {
        FavouritesFragment fragment = new FavouritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites_fragments, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpActionBar();
    }

    public void setUpActionBar() {
        ((HomeActivity) getActivity()).setActionBarTitle("Favourites");
        if (getActivity() instanceof TabBarCommunicator) {
            ((TabBarCommunicator) getActivity()).fragmentAttached(TabBarCommunicator.TabPage.ProfilePage);
        }
    }
}

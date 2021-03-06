package com.example.tailoredtech.smartparking.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.smartparking.R;
import com.example.tailoredtech.smartparking.TabBarCommunicator;
import com.example.tailoredtech.smartparking.activities.HomeActivity;
import com.example.tailoredtech.smartparking.activities.LoginActivity;
import com.example.tailoredtech.smartparking.activities.PostSlotActivity;
import com.example.tailoredtech.smartparking.widget.AppButton;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        AppButton textView = (AppButton) view.findViewById(R.id.add_free_slot);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PostSlotActivity.class));
            }
        });

        AppButton logout = (AppButton) view.findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpActionBar();
    }

    public void setUpActionBar() {
        ((HomeActivity) getActivity()).setActionBarTitle("Profile");
        if (getActivity() instanceof TabBarCommunicator) {
            ((TabBarCommunicator) getActivity()).fragmentAttached(TabBarCommunicator.TabPage.ProfilePage);
        }
    }
}

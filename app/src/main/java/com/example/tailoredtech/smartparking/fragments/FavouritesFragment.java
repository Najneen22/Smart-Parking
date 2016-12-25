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
import com.example.tailoredtech.smartparking.TabBarCommunicator;
import com.example.tailoredtech.smartparking.activities.HomeActivity;
import com.example.tailoredtech.smartparking.activities.PaymentActivity;
import com.example.tailoredtech.smartparking.activities.SelectBookingArea;
import com.example.tailoredtech.smartparking.adapter.BookingAdapter;
import com.example.tailoredtech.smartparking.models.Parking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class FavouritesFragment extends Fragment {

    private RecyclerView parkingListView;
    private BookingAdapter bookingAdapter;
    private String parkingStringJson="[{\n" +
            "\t\"pid\":\"1\",\n" +
            "\t\"pname\":\"Amanora Parking\",\n" +
            "\t\"PImg\":\"https://i.ytimg.com/vi/NIl02Ddcwyc/maxresdefault.jpg\",\n" +
            "\t\"isPremium\":\"true\",\n" +
            "\t\"bikefare\":\"20\",\n" +
            "\t\"carfare\":\"150\",\n" +
            "\t\"mode\":\"Day Basis\",\n" +
            "\t\"isavail\":\"true\"\n" +
            "}]";

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourites_fragments, container, false);
        parkingListView = (RecyclerView) view.findViewById(R.id.parking_list);
        bookingAdapter = new BookingAdapter(getActivity());
        parkingListView.setAdapter(bookingAdapter);
        parkingListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bookingAdapter.setListener(new BookingAdapter.IBook() {
            @Override
            public void onItemClick(int position, Parking parking) {
                if(parking.getIsPremium())
                {
                    startActivity(new Intent(getActivity(), SelectBookingArea.class));
                }
                else {
                    startActivity(new Intent(getActivity(), PaymentActivity.class));
                }
            }
        });

        JSONArray parkingArray = null;

        try {
            parkingArray = new JSONArray(parkingStringJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<Parking> parking = getParkingList(parkingArray);
        bookingAdapter.updateList(parking);

        return view;
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

    private ArrayList<Parking> getParkingList(JSONArray news) {
        ArrayList<Parking> parkingList=new ArrayList<>();
        for(int i = 0; i < news.length(); i++)
        {
            JSONObject newsObj = news.optJSONObject(i);
            if(newsObj!=null)
            {
                parkingList.add(Parking.initialiseFromJSON(newsObj));
            }
        }
        return parkingList;
    }
}

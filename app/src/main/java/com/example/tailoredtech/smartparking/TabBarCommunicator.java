package com.example.tailoredtech.smartparking;

/**
 * Created by tailoredtech on 12/25/2016.
 */

public interface TabBarCommunicator {

    enum TabPage{
        DiscoverPage, FavouritePage, ProfilePage, MorePage;
    }
    void fragmentAttached(TabPage tabPage);
}

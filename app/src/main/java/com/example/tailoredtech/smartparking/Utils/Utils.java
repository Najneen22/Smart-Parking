package com.example.tailoredtech.smartparking.Utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Najneen on 12/24/2016.
 */

public class Utils {

    public static boolean isInternetConnected(Context context) {
        boolean isInternetConnected = false;
        try {
            ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context
                    .CONNECTIVITY_SERVICE);
            if (connManager.getActiveNetworkInfo() != null && connManager.getActiveNetworkInfo()
                    .isAvailable() && connManager.getActiveNetworkInfo().isConnected()) {
                isInternetConnected = true;
            }
        } catch (Exception ex) {
            isInternetConnected = false;
        }
        return isInternetConnected;
    }
}

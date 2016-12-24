package com.example.tailoredtech.smartparking.model;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.TableInfo;

import java.util.ArrayList;
import java.util.Iterator;

public class DBHelper
{
    // Save
    public static void saveAllUser(ArrayList<User> users)
    {
        clearUsers();

        ArrayList<User> allElements = new ArrayList<>();
        ActiveAndroid.beginTransaction();
        try
        {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext())
            {
                User user = iterator.next();
                user.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally
        {
            ActiveAndroid.endTransaction();
        }
    }

    public static void addUser(User user)
    {
        ActiveAndroid.beginTransaction();
        try {
            user.save();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }

    // Truncate
    public static void clearUsers()
    {
        ActiveAndroid.beginTransaction();
        try
        {
            truncate(User.class);
            truncate(User.class);
            ActiveAndroid.setTransactionSuccessful();
        }
        finally
        {
            ActiveAndroid.endTransaction();
        }
    }

    public static void truncate(Class<? extends Model> type){
        TableInfo tableInfo = Cache.getTableInfo(type);
        ActiveAndroid.execSQL(
                String.format("DELETE FROM %s;",
                        tableInfo.getTableName()));
    }
}

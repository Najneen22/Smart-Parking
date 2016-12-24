package com.example.tailoredtech.smartparking.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tailoredtech on 12/25/2016.
 */

@Table(name = "UserModel")
public class User extends Model{

    @Column(name = "user_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("user_id")
    @Expose
    private int userId;

    @Column(name = "user_name")
    @SerializedName("user_name")
    @Expose
    private String userName;

    @Column(name = "license_id")
    @SerializedName("license_id")
    @Expose
    private String licenseId;

    @Column(name = "profile_picture")
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;

    @Column(name = "vehicle_number")
    @SerializedName("vehicle_number")
    @Expose
    private String vehicleNumber;

    // Query Starts
    public static List<User> getUsers()
    {
        return new Select()
                .from(User.class)
                .execute();
    }

    public static List<User> deleteCartProduct(User user)
    {
        new Delete()
                .from(User.class)
                .where("user_id = ?",user.getUserId()).execute();

        return getUsers();
    }

    private static User getSingleUser(String userId)
    {
        return new Select().from(User.class)
                .where("user_id = ?",userId)
                .executeSingle();
    }
    //Query Ends

    //Getter Setter Starts
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    //Getter Setter Ends
}

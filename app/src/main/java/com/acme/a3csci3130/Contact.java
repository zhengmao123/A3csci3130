package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {
    public  String uid;
    public  String bid;
    public  String name;
    public  String pb;
    public  String address;
    public  String provice;


    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }


    public Contact(String uid, String bid, String name,String pb, String address, String provice){

        this.uid=uid;
        this.bid = bid;
        this.name = name;
        this.pb = pb;
        this.address=address;
        this.provice=provice;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("uid",uid);
        result.put("bid", bid);
        result.put("name", name);
        result.put("email", pb);
        result.put("address",address);
        result.put("provice",provice);

        return result;
    }
}

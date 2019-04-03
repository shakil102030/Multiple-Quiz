package com.example.shakil.androidserver;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedprefmanager {
    private static Sharedprefmanager mInstance;
    private static Context con;

    private Sharedprefmanager(Context context) {
        con = context;
    }

    public static Sharedprefmanager getInstance(Context context){
        if(mInstance == null){
            mInstance = new Sharedprefmanager(context);
        }

        return mInstance;
    }

    public Boolean userlogin(int id, String username, String password){
        SharedPreferences sharedPreferences = con.getSharedPreferences("Sharedpreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("ID", id);
        editor.putString("USERNAME", username);
        editor.putString("PASSWORD", password);
        editor.apply();
        return true;
    }

    public Boolean islogedin(){
        SharedPreferences sharedPreferences = con.getSharedPreferences("Sharedpreference", Context.MODE_PRIVATE);
        if(sharedPreferences.getString("USERNAME", null) != null){
            return true;
        }
        return false;
    }

    public Boolean logout(){
        SharedPreferences sharedPreferences = con.getSharedPreferences("Sharedpreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = con.getSharedPreferences("Sharedpreference", Context.MODE_PRIVATE);
        return (sharedPreferences.getString("USERNAME", null));
    }

    public String getUserpassword(){
        SharedPreferences sharedPreferences = con.getSharedPreferences("Sharedpreference", Context.MODE_PRIVATE);
        return (sharedPreferences.getString("PASSWORD", null));
    }

}
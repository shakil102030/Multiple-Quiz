package com.example.shakil.multiplequiz;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("mynm", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void setSignedin(Boolean loggedin){
        editor.putBoolean("loggedInmode", loggedin);
        editor.commit();

    }

    public boolean Signedin(){
        return sharedPreferences.getBoolean("loggedInmode",false);
    }


}
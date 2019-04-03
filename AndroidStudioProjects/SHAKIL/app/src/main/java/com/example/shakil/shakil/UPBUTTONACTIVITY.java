package com.example.shakil.shakil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class UPBUTTONACTIVITY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upbuttonactivity);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    public void openA(View view){
        Intent intent = new Intent(this,ActivityA.class);
        startActivity(intent);

    }
}

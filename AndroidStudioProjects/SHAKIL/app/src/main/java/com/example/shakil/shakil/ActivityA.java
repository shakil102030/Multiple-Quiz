package com.example.shakil.shakil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
    }
    public void openB(View view){
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);

    }
}

package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Fram extends AppCompatActivity implements View.OnClickListener{

    private ImageView firstimageid,secondimageid,thirdimageid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fram);

        firstimageid = (ImageView) findViewById(R.id.firsimageid);
        secondimageid = (ImageView) findViewById(R.id.secondimageid);
        thirdimageid = (ImageView) findViewById(R.id.thirdimageid);

        firstimageid.setOnClickListener(this);
        secondimageid.setOnClickListener(this);
        thirdimageid.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.firsimageid){
            firstimageid.setVisibility(View.GONE);
            secondimageid.setVisibility(View.VISIBLE);
            thirdimageid.setVisibility(View.GONE);
        }
        else if(v.getId() == R.id.secondimageid){
            firstimageid.setVisibility(View.GONE);
            secondimageid.setVisibility(View.GONE);
            thirdimageid.setVisibility(View.VISIBLE);
        }
        else if(v.getId() == R.id.thirdimageid){
            firstimageid.setVisibility(View.VISIBLE);
            secondimageid.setVisibility(View.GONE);
            thirdimageid.setVisibility(View.GONE);
        }

    }
}

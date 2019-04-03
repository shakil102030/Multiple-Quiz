package com.example.shakil.androidserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Show extends AppCompatActivity {

    TextView title,name;
    //details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        title = (TextView) findViewById(R.id.title);
        name = (TextView) findViewById(R.id.name);
       // details = (TextView) findViewById(R.id.details);

        String t = getIntent().getStringExtra("email");
        String n = getIntent().getStringExtra("password");
        //String d = getIntent().getStringExtra("Details");


        title.setText(t);
        name.setText(n);
        //details.setText(d);
    }
}

package com.example.shakil.sujon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Hundle_Service extends AppCompatActivity {
    Button StartserviceButtonId,StopserviceButtonId;
    EditText EdittextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundle__service);
        StartserviceButtonId = (Button) findViewById(R.id.StartserviceButtonId);
        StopserviceButtonId = (Button) findViewById(R.id.StopserviceButtonId);
        EdittextId = (EditText) findViewById(R.id.EdittextId);

        StartserviceButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hundle_Service.this, MyService.class);
                startService(intent);

            }
        });

        StopserviceButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hundle_Service.this, MyService.class);
                startService(intent);
            }
        });

    }
}

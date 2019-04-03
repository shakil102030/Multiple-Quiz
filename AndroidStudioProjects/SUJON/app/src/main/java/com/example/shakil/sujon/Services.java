package com.example.shakil.sujon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {
    Button StartserviceButtonId,StopserviceButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        StartserviceButtonId = (Button) findViewById(R.id.StartserviceButtonId);
        StopserviceButtonId = (Button) findViewById(R.id.StopserviceButtonId);

        StartserviceButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Services.this, TheService.class);
                startService(intent);

            }
        });

        StopserviceButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Services.this, TheService.class);
                stopService(intent);

            }
        });
    }
}

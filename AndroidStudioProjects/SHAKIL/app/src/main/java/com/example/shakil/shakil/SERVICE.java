package com.example.shakil.shakil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SERVICE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


    }
    public void startservice(View view) {
        Intent intent = new Intent(SERVICE.this, MyService.class);
        startService(intent);
    }

    public void stopservice(View view) {
        Intent intent = new Intent(SERVICE.this, MyService.class);
        stopService(intent);
    }


}

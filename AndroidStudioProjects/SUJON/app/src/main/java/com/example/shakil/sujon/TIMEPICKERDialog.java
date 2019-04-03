package com.example.shakil.sujon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TIMEPICKERDialog extends AppCompatActivity {
    private TimePicker timepick;
    Button time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepickerdialog);

        timepick = (TimePicker) findViewById(R.id.timePick);
        time = (Button) findViewById(R.id.time);
        timepick.setIs24HourView(true);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TIMEPICKERDialog.this, timepick.getCurrentHour()+" : "+timepick.getCurrentMinute(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

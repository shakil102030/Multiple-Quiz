package com.example.shakil.sujon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Timepicker extends AppCompatActivity {

    private TimePicker Atimepicker;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        Atimepicker = (TimePicker) findViewById(R.id.timePicker);
        show = (Button) findViewById(R.id.show);
        Atimepicker.setIs24HourView(true);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Timepicker.this, Atimepicker.getCurrentHour()+" : "+Atimepicker.getCurrentMinute(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

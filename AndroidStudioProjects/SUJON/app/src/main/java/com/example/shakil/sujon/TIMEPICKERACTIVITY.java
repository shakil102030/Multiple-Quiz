package com.example.shakil.sujon;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TIMEPICKERACTIVITY extends AppCompatActivity {

    Button buttonid;
    static final int dialog_id=0;
    int hour_h;
    int minute_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepickeractivity);

        buttonid = (Button) findViewById(R.id.buttonid);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialog_id);
            }
        });


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(dialog_id == id){
            return new TimePickerDialog(TIMEPICKERACTIVITY.this, kTimePickerDialog, hour_h, minute_m,false);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener kTimePickerDialog = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            hour_h = hourOfDay;
            minute_m =minute;
            Toast.makeText(TIMEPICKERACTIVITY.this, hour_h + " : " +minute_m, Toast.LENGTH_SHORT).show();

        }
    };


}

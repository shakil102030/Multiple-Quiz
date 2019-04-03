package com.example.shakil.sujon;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DATEPICKER extends AppCompatActivity {
    Button datepickerid;
    static final int dialog_id=0;

    int Year_x,Month_x,Day_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        final Calendar calender;
        calender = Calendar.getInstance();

        Year_x = calender.get(Calendar.YEAR);
        Month_x = calender.get(Calendar.MONTH);
        Day_x = calender.get(Calendar.DAY_OF_MONTH);




        datepickerid = (Button) findViewById(R.id.datepickerid);

        datepickerid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialog_id);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(dialog_id == id){
            return new DatePickerDialog(this,dPickerDialog, Year_x,Month_x,Day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerDialog = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year_x = year;
            Month_x = monthOfYear+1;
            Day_x = dayOfMonth;

            Toast.makeText(DATEPICKER.this, Day_x+"/"+Month_x+"/"+Year_x, Toast.LENGTH_SHORT).show();
        }
    };
}

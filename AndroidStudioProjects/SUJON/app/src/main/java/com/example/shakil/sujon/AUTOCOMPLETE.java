package com.example.shakil.sujon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AUTOCOMPLETE extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;

    String[] name = {"Shakil","Sohan","Sazzad","Seyam","Shaam","Sujon","Siam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item, name);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}

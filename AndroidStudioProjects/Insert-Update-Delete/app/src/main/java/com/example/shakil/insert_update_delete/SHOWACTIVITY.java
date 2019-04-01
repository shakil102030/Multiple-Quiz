package com.example.shakil.insert_update_delete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SHOWACTIVITY extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showactivity);

        listView = (ListView) findViewById(R.id.listView);


        DbHelper dbHelper = new DbHelper(getApplicationContext());
        String[] name = dbHelper.getData();

         listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.datalayout, R.id.textId, name));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SAVEACTIVITY.class);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });


    }


}

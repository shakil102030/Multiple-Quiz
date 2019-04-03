package com.example.shakil.shakil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Custom_View extends AppCompatActivity {

    ListView customlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__view);

        customlistview = (ListView) findViewById(R.id.CustomListViewId);

        final String[] tname = {"Shakil","Sohan","Sazzad","Tamim","Tuni"};
        int[] timage = {R.drawable.ic_shakil,R.drawable.ic_sohan,
                R.drawable.ic_sazzad,R.drawable.ic_tamim,R.drawable.ic_tuni};

        CustomAdaptor customAdaptor = new CustomAdaptor(this,tname,timage);
        customlistview.setAdapter(customAdaptor);

        customlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Custom_View.this, tname[position], Toast.LENGTH_SHORT).show();
            }
        });


    }
}

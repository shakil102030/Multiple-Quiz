package com.example.shakil.sujon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GRIDVIEW extends AppCompatActivity {
    private GridView gridViewTextgridId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridViewTextgridId = (GridView) findViewById(R.id.gridViewTextgridId);


        final String[] countryArraytName = getResources().getStringArray(R.array.Country_name);

        int[] countrypictureId = {R.drawable.ic_sazzad,R.drawable.ic_shakil,R.drawable.ic_sohan,
                        R.drawable.ic_search,R.drawable.ic_tamim,R.drawable.ic_tuni,
                        R.drawable.ic_sazzad,R.drawable.ic_search,R.drawable.ic_shakil,
                        R.drawable.ic_tuni, R.drawable.ic_sohan,R.drawable.ic_tamim,
                        R.drawable.ic_search,R.drawable.ic_shakil,R.drawable.ic_tamim,
                        R.drawable.we};
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.grid_layout,R.id.gridTextId,countryArraytName);
        CustomAdapter customAdapter = new CustomAdapter(this,countryArraytName,countrypictureId);
        gridViewTextgridId.setAdapter(customAdapter);

        gridViewTextgridId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GRIDVIEW.this, "Country Name " + countryArraytName[position] +" Position : " + position, Toast.LENGTH_SHORT).show();
            }
        });



    }
}

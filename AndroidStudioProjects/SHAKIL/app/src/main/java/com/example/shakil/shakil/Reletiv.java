package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Reletiv extends AppCompatActivity {

    ListView listView;
     ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reletiv);

        listView = (ListView) findViewById(R.id.listview);


        final String[] name = {"Shakil","Sujon","Sohan","Sazzad","Tamim"};

       // final ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.listlayout, R.id.ltext, name);
         arrayAdapter = new ArrayAdapter(this,R.layout.listlayout, R.id.ltext, name);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) arrayAdapter.getItem(position);

                //Toast.makeText(getApplicationContext(), "Position: "+name[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(Reletiv.this, value, Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        MenuItem menuItem = menu.findItem(R.id.searchViewId);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

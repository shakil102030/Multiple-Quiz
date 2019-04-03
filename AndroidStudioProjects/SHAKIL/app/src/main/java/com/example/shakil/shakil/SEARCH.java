package com.example.shakil.shakil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SEARCH extends AppCompatActivity {
     String[] countryname;
     ListView listviewid;
     ArrayAdapter arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listviewid = (ListView) findViewById(R.id.listviewid);

         countryname = getResources().getStringArray(R.array.country_name);

         arrayadapter = new ArrayAdapter(this,R.layout.country_layout,R.id.CountryTextId,countryname);
         listviewid.setAdapter(arrayadapter);

        listviewid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) arrayadapter.getItem(position);
                Toast.makeText(SEARCH.this, "Position :  " + value, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.menu_layout,menu);

        MenuItem menuitem = menu.findItem(R.id.searchViewId);

        SearchView searchview = (SearchView) menuitem.getActionView();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayadapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

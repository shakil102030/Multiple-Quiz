package com.example.shakil.shakil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ACTION_BAR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action__bar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.searchViewId){
            Toast.makeText(ACTION_BAR.this, "Search", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

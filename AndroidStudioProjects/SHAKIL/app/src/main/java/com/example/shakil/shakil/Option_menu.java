package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Option_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settingItemId) {
            Toast.makeText(Option_menu.this, "Setting Selected", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.shereItemId) {
            Toast.makeText(Option_menu.this, "Shere Selected", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.feedbackItemId) {
            Toast.makeText(Option_menu.this, "Feedback Selected", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.profileItemId) {
            Toast.makeText(Option_menu.this, "Profile Selected", Toast.LENGTH_SHORT).show();
        }
        return true;

    }
}

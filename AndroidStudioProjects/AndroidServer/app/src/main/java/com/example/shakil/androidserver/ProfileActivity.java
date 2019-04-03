package com.example.shakil.androidserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    TextView emailTextid,passwordTextid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailTextid = (TextView) findViewById(R.id.emailTextid);
        passwordTextid = (TextView) findViewById(R.id.passwordTextid);

        if(!Sharedprefmanager.getInstance(this).islogedin()){
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            return;
        }

        emailTextid.setText(Sharedprefmanager.getInstance(this).getUsername());
        passwordTextid.setText(Sharedprefmanager.getInstance(this).getUserpassword());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutId:
                Sharedprefmanager.getInstance(this).logout();
                break;
            case R.id.settingId:
                Toast.makeText(ProfileActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}

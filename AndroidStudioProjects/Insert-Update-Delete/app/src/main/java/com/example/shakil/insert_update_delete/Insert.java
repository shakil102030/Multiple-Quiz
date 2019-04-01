package com.example.shakil.insert_update_delete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity implements View.OnClickListener{

     EditText username,password;
     Button save,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.UsernameEditTextId);
        password = (EditText) findViewById(R.id.PasswordEditTextId);
        save = (Button) findViewById(R.id.SaveButtonId);
        show = (Button) findViewById(R.id.ShowButtonId);

        save.setOnClickListener(this);
        show.setOnClickListener(this);



    }

    DbHelper dbHelper = new DbHelper(Insert.this);

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.SaveButtonId){

            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.equals("") && pass.equals("")){
                Toast.makeText(Insert.this, "Please Enter Name/BirthDay", Toast.LENGTH_SHORT).show();
            }
            else {
                dbHelper.DataAddtoDatabase(name, pass);
                Toast.makeText(Insert.this, "Succesfully Saved", Toast.LENGTH_SHORT).show();
            }

        }
        else if(v.getId() == R.id.ShowButtonId){
            Intent intent = new Intent(getApplicationContext(), SHOWACTIVITY.class);
            startActivity(intent);
        }
        }


    }


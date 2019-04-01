package com.example.shakil.multiplequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button slogin,sregister;
    private EditText esemail, espass;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        slogin = (Button) findViewById(R.id.sloginId);
        sregister = (Button) findViewById(R.id.sregisterId);
        esemail = (EditText) findViewById(R.id.semailId);
        espass = (EditText) findViewById(R.id.spasswordId);

        slogin.setOnClickListener(this);
        sregister.setOnClickListener(this);

        if(session.Signedin()){
            startActivity(new Intent(Login.this,MainActivity.class));
            finish();
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sloginId:
                log();
                break;
            case R.id.sregisterId:
                startActivity();
                break;
            default:


        }
    }

    private void log(){
        String email = esemail.getText().toString();
        String pass = espass.getText().toString();

        if(db.gettingDatafromDatabase(email,pass)){
            session.setSignedin(true);
            startActivity(new Intent( Login.this, MainActivity.class));
        }
        else{
            Toast.makeText(Login.this, "Wrong email/password", Toast.LENGTH_SHORT).show();
        }


    }




    private void startActivity() {
        startActivity(new Intent( Login.this, Registration.class));
    }


}



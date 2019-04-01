package com.example.shakil.multiplequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener{
        Button register;
        TextView login;
        private EditText etemail, etpass;
        private DbHelper db;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            db = new DbHelper(this);
            register = (Button) findViewById(R.id.RegistrationButtonId);
            login = (TextView) findViewById(R.id.LoginTextViewId);
            etemail = (EditText) findViewById(R.id.EmailEditTextId);
            etpass = (EditText) findViewById(R.id.PasswordEditTextId);

            register.setOnClickListener(this);
            login.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.RegistrationButtonId){
                register();
            }
            else if(v.getId() == R.id.LoginTextViewId){
                startActivity(new Intent(Registration.this, Login.class));
                finish();
            }
        }


    private void register(){
        String email = etemail.getText().toString();
        String pass = etpass.getText().toString();
        if(email.isEmpty() && pass.isEmpty()){
            display("Username/Password Field Empty");
        }
        else{
            db.addingDatatoDatabase(email,pass);
            display("User Registered");
            startActivity(new Intent(Registration.this, Login.class));
            finish();
        }

    }

    private void display(String message){
        Toast.makeText(Registration.this, message, Toast.LENGTH_SHORT).show();
    }

}



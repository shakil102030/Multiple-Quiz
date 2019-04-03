package com.example.shakil.sujon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;

public class Login extends AppCompatActivity {
    private EditText qemail,qpassword;
    private TextView text;
    Button button;
    int atemp = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        qemail = (EditText) findViewById(R.id.email);
        qpassword = (EditText) findViewById(R.id.password);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = qemail.getText().toString();
                String password = qpassword.getText().toString();

                if(email.equals("user") && password.equals("password")){

                    Toast.makeText(getApplicationContext(),text.getText() , Toast.LENGTH_SHORT).show();
                }
                else {

                    atemp--;
                    text.setText(java.lang.Integer.toString(atemp));
                    if(atemp == 0){
                        button.setEnabled(false);
                    }

                }
            }
        });
    }
}

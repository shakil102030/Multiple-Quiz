package com.example.shakil.androidserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText email,password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = (EditText) findViewById(R.id.emailEditId);
        password = (EditText) findViewById(R.id.passwordEditId);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingdata();
                Toast.makeText(Registration.this, "shakil", Toast.LENGTH_SHORT).show();

            }
        });

    }



    private void sendingdata() {
        final String temail = email.getText().toString();
        final String tpassword = password.getText().toString();

        StringRequest stringReque = new StringRequest(Request.Method.POST, Databas.my_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Eooro Volly ",error);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> parm = new HashMap<String, String>();


                parm.put("email", temail);
                parm.put("password", tpassword);


                return parm;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringReque);
        Toast.makeText(Registration.this, "sohan", Toast.LENGTH_SHORT).show();
    }
}

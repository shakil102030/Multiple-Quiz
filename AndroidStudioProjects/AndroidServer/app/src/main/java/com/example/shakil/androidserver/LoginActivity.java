package com.example.shakil.androidserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    EditText username1,password1;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username1 = (EditText) findViewById(R.id.usernameTextId);
        password1 = (EditText) findViewById(R.id.passwordTextId);
        login = (Button) findViewById(R.id.loginButtonId);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlog();
            }
        });

    }


    public void userlog() {
        StringRequest strq= new StringRequest(Request.Method.POST, Databas.my_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                      if(jsonObject.getBoolean("error")){
                          Sharedprefmanager.getInstance(getApplicationContext()).userlogin(
                                  jsonObject.getInt("id"),
                                  jsonObject.getString("title"),
                                  jsonObject.getString("description")
                          );


                          Toast.makeText(LoginActivity.this, "Successfully LogedIn", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                      }
                    else{
                          Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();


                      }

                } catch (JSONException e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams ()throws AuthFailureError {


                Map<String, String> parm = new HashMap<String, String>();
                parm.put("title", username1.getText().toString());
                parm.put("description", password1.getText().toString());


                return parm;
            }
        };
        AppController.getInstance().addToRequestQueue(strq);

    }


}

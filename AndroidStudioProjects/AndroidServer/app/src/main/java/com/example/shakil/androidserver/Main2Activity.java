package com.example.shakil.androidserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
     EditText title1,name1;
            // ,details1;
     Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title1 = (EditText) findViewById(R.id.titleTextId);
        name1 = (EditText) findViewById(R.id.nameTextId);
        //details1 = (EditText) findViewById(R.id.detailsTextId);
        submit = (Button) findViewById(R.id.submitButtonId);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingdata();
                Toast.makeText(Main2Activity.this, "shakil", Toast.LENGTH_SHORT).show();

            }
        });

    }



private void sendingdata() {

    StringRequest stringRequest = new StringRequest(Request.Method.POST, Databas.my_url, new Response.Listener<String>() {
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


            parm.put("email", title1.getText().toString());
            parm.put("password", name1.getText().toString());
            //parm.put("details", details1.getText().toString());

            return parm;

        }
    };

    AppController.getInstance().addToRequestQueue(stringRequest);
    Toast.makeText(Main2Activity.this, "sohan", Toast.LENGTH_SHORT).show();
}

}

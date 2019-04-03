package com.example.shakil.androidserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* if(!Sharedprefmanager.getInstance(this).islogedin()){
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }*/

        listView = (ListView) findViewById(R.id.listView);

        fatchingdata();
    }

    public void fatchingdata(){

    //String url = "abcder";
       // String my_url = "https://api.myjson.com/bins/12pa2m";
    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Databas.my_url, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            final String[] title = new String[response.length()];
            final String[] name = new String[response.length()];
            final String[] details = new String[response.length()];
            for (int i = 0; i < response.length(); i++) {
                JSONObject jsonObj = null;
                try {
                    jsonObj = (JSONObject) response.get(i);
                    title[i] = jsonObj.getString("email");
                    name[i] = jsonObj.getString("password");
                    //details[i] = jsonObj.getString("details");
                } catch (JSONException e) {

                }


            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.layout, R.id.textId, name);

            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), Show.class);
                    intent.putExtra("email", title);
                    intent.putExtra("password", name);
                    //intent.putExtra("Details", details);
                    startActivityForResult(intent, 2);
                }
            });


        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d("Volley Log ", error);
        }
    });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
}


}

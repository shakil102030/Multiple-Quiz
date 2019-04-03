package com.example.shakil.androidjson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageLoadingActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loading);


        listView = (ListView) findViewById(R.id.listViewid);

        JsonT jsonT = new JsonT();
        jsonT.execute();

    }

    public class JsonT extends AsyncTask<String, String, List<Democlass>> {

        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader2;

        @Override
        protected List<Democlass> doInBackground(String... params) {

            try {
                URL url = new URL("https://api.myjson.com/bins/or14q");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String lcount = "";

                while ((lcount= bufferedReader2.readLine())!=null){
                    stringBuffer.append(lcount);
                }
                String file = stringBuffer.toString();
                JSONObject jsonObject1 = new JSONObject(file);
                JSONArray jsonArray1 = jsonObject1.getJSONArray("picture");



                List<Democlass> democlassList = new ArrayList<>();

                for (int i=0;i<jsonArray1.length();i++){
                    JSONObject jsonObject2 = jsonArray1.getJSONObject(i);

                    Democlass democlass = new Democlass();
                    democlass.setImage(jsonObject2.getString("name"));
                    democlass.setName(jsonObject2.getString("image"));

                    democlassList.add(democlass);


                }
                return democlassList;


            } catch (MalformedURLException e) {

            } catch (IOException e) {

            } catch (JSONException e) {

            } finally {
                httpURLConnection.disconnect();

            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Democlass> s) {
            CustomAdaptor customAdaptor = new CustomAdaptor(getApplicationContext(), R.layout.customlayout, s);
            listView.setAdapter(customAdaptor);

        }

       /* customlistview = (ListView) findViewById(R.id.CustomListViewId);

        final String[] tname = {"Shakil","Sohan","Sazzad","Tamim","Tuni"};
        int[] timage = {R.drawable.ic_shakil,R.drawable.ic_sohan,
                R.drawable.ic_sazzad,R.drawable.ic_tamim,R.drawable.ic_tuni};



        CustomAdaptor customAdaptor = new CustomAdaptor(this,tname,timage);
        customlistview.setAdapter(customAdaptor);

        customlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Custom_View.this, tname[position], Toast.LENGTH_SHORT).show();
            }
        });*/








    }
}

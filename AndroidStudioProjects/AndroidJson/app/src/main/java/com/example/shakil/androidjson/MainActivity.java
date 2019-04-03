package com.example.shakil.androidjson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    TextView textid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textid = (TextView) findViewById(R.id.textid);

        JsonT jsonT = new JsonT();
        jsonT.execute();

    }

    public class JsonT extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader1 = null;

            try {
                URL url = new URL("https://api.myjson.com/bins/fd05e");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                 bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                String lcount = "";

                while ((lcount= bufferedReader1.readLine())!=null){
                      stringBuffer.append(lcount);
                }

                String fil = stringBuffer.toString();
                JSONObject jsonObject4 = new JSONObject(fil);
                JSONArray jsonArray5 = jsonObject4.getJSONArray("cars");



                for (int i=0;i<jsonArray5.length();i++){
                    JSONObject jsonObject6 = jsonArray5.getJSONObject(i);

                    String name = jsonObject6.getString("name");
                    String age = jsonObject6.getString("age");
                    String description = jsonObject6.getString("description");

                    stringBuffer2.append(name+"\n"+age+"\n"+description+"\n");
                }
                return stringBuffer2.toString();

            } catch (MalformedURLException e) {

            } catch (IOException e) {

            } catch (JSONException e) {

            } finally {
                httpURLConnection.disconnect();
                try {
                    bufferedReader1.close();
                } catch (IOException e) {

                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            textid.setText(s);

        }
    }
}

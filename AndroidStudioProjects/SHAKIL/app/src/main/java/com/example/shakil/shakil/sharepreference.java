package com.example.shakil.shakil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sharepreference extends AppCompatActivity implements View.OnClickListener{

    EditText name,password;
    Button save,load;
    TextView textView;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreference);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);
        textView = (TextView) findViewById(R.id.textview);

        save.setOnClickListener(this);
        load.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.save) {

            String nm = name.getText().toString();
            String pass = password.getText().toString();

            if (nm.equals("") && pass.equals("")) {
                Toast.makeText(sharepreference.this, "name and password is empty", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences sharedpreferences = getSharedPreferences("namepassword", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name",nm);
                editor.putString("password",pass);
                editor.commit();
                Toast.makeText(sharepreference.this, "Successfully saved", Toast.LENGTH_SHORT).show();

            }
        }
        else if(v.getId() == R.id.load){
            SharedPreferences sharedpreferences = getSharedPreferences("namepassword", Context.MODE_PRIVATE);
            if(sharedpreferences.contains("name") && sharedpreferences.contains("password")){
                String data = sharedpreferences.getString("name","Data not found");
                String value = sharedpreferences.getString("password","Data not found");

                textView.setText(data + "\n" + value);
            }

        }

    }
}

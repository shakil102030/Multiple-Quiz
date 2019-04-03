package com.example.shakil.sujon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Integer extends AppCompatActivity {


    private TextView textView;
    private EditText editText,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integer);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = java.lang.Integer.parseInt(editText.getText().toString());
                int num2 = java.lang.Integer.parseInt(editText2.getText().toString());

                int sum = num1 + num2;

                textView.setText(java.lang.Integer.toString(sum));

                Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
            }
        });


    }




}

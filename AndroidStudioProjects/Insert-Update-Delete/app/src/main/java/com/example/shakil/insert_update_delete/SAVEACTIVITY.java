package com.example.shakil.insert_update_delete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SAVEACTIVITY extends AppCompatActivity {
    EditText edittext;
    Button UpdateButtonId,DeleteButtonId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveactivity);
        edittext = (EditText) findViewById(R.id.edittext);

        UpdateButtonId = (Button) findViewById(R.id.UpdateButtonId);
        DeleteButtonId = (Button) findViewById(R.id.DeleteButtonId);



        final int position = getIntent().getIntExtra("POSITION", 999);
        final DbHelper dbHelper = new DbHelper(SAVEACTIVITY.this);

        String text = dbHelper.Edittext(position+1);
        edittext.setText(text);

        edittext.setSelection(edittext.getText().length());

        UpdateButtonId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(edittext.getText().toString().equals("")){
                    Toast.makeText(SAVEACTIVITY.this, "Please Enter Some Text", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.UpdateFunction(position + 1, edittext.getText().toString());
                    Toast.makeText(SAVEACTIVITY.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DeleteButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edittext.getText().toString().equals("")){
                    Toast.makeText(SAVEACTIVITY.this, "Some Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.DeleteFunction(dbHelper.Edittext(position + 1));
                    Toast.makeText(SAVEACTIVITY.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}

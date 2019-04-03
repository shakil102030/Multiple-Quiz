package com.example.shakil.shakil;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ALERT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void onClickAlert(View view) {

        AlertDialog.Builder alertbuilter = new AlertDialog.Builder(ALERT.this);
        alertbuilter.setTitle("Atention!!");
        alertbuilter.setMessage("You are 18++ in a site?");
        alertbuilter.setIcon(R.drawable.play);
        alertbuilter.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ALERT.this, "yes I am ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertbuilter.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ALERT.this, "No I am not", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        AlertDialog alertdialog = alertbuilter.create();
        alertdialog.show();


    }
}

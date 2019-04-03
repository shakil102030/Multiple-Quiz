package com.example.shakil.sujon;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button integer,password,login,time,timepicker2,autocompletetext,time_picker_id;
    Button datepicker,timepic,notify,service,hundle,gridview,fragmentButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        integer = (Button) findViewById(R.id.integer);
        password = (Button) findViewById(R.id.passwordId);
        login = (Button) findViewById(R.id.login);
        time = (Button) findViewById(R.id.time);
        timepicker2 = (Button) findViewById(R.id.timepicker2);
        autocompletetext= (Button) findViewById(R.id.autocompletetext);
        time_picker_id = (Button) findViewById(R.id.time_picker_id);
        datepicker = (Button) findViewById(R.id.datepicker);
        timepic = (Button) findViewById(R.id.timepic);
        notify = (Button) findViewById(R.id.notify);
        service = (Button) findViewById(R.id.service);
        hundle = (Button) findViewById(R.id.hundle);
        gridview = (Button) findViewById(R.id.gridview);
        fragmentButtonId = (Button) findViewById(R.id.fragmentButtonId);


        integer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Integer.class);
                startActivity(intent);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Password.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Timepicker.class);
                startActivity(intent);
            }
        });

        timepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), time_Picker.class);
                startActivity(intent);
            }
        });

        autocompletetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AUTOCOMPLETE.class);
                startActivity(intent);
            }
        });

        time_picker_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TIMEPICKERDialog.class);
                startActivity(intent);
            }
        });
        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DATEPICKER.class);
                startActivity(intent);
            }
        });
        timepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TIMEPICKERACTIVITY.class);
                startActivity(intent);
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Services.class);
                startActivity(intent);
            }
        });

        hundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hundle_Service.class);
                startActivity(intent);
            }
        });

        gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GRIDVIEW.class);
                startActivity(intent);
            }
        });
        fragmentButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FRAGMENT.class);
                startActivity(intent);
            }
        });





        notify.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 0, new Intent[]{intent}, 0);

                Notification notification = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("ContentTitle")
                        .setContentText("ContentText")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .addAction(R.mipmap.ic_launcher, "Action1", pendingIntent)
                        .addAction(R.mipmap.ic_launcher, "Action2", pendingIntent)
                        .setContentIntent(pendingIntent).getNotification();

                   notification.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                       notificationManager.notify(0,notification);



            }
        });




    }
}

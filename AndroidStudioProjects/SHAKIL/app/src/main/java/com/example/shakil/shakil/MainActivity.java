package com.example.shakil.shakil;

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

public class MainActivity extends AppCompatActivity{
    Button take_photo,alert,photo,share,listview,frame_l,actionbar,ratingbar;
    Button framelayout,seekbar,notification,xmltrick,service,search,optionmenu;
    Button customview,upButton,fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        take_photo = (Button) findViewById(R.id.take_photo);
        alert = (Button) findViewById(R.id.alert);
        photo = (Button) findViewById(R.id.photo);
        share = (Button) findViewById(R.id.share_pre);
        listview = (Button) findViewById(R.id.listview);
        frame_l = (Button) findViewById(R.id.frame_l);
        actionbar = (Button) findViewById(R.id.actionbar);
        ratingbar = (Button) findViewById(R.id.ratingbar);
        framelayout = (Button) findViewById(R.id.framelayout);
        seekbar = (Button) findViewById(R.id.seekbar);
        notification = (Button) findViewById(R.id.notification);
        xmltrick = (Button) findViewById(R.id.xmltrick);
        service = (Button) findViewById(R.id.service);
        search = (Button) findViewById(R.id.search);
        optionmenu = (Button) findViewById(R.id.optionmenu);
        customview = (Button) findViewById(R.id.customview);
        upButton = (Button) findViewById(R.id.upButton);
        fragment = (Button) findViewById(R.id.fragment);



        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TakePhoto.class);
                startActivity(intent);
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Photo.class);
                startActivity(intent);
            }
        });


        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ALERT.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sharepreference.class);
                startActivity(intent);
            }
        });
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Reletiv.class);
                startActivity(intent);
            }
        });
        frame_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fram.class);
                startActivity(intent);
            }
        });

        actionbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ACTION_BAR.class);
                startActivity(intent);
            }
        });

        ratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RATING_BAR.class);
                startActivity(intent);
            }
        });

        framelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FRAMELAYOUT.class);
                startActivity(intent);
            }
        });

        seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SEEKBAR.class);
                startActivity(intent);
            }
        });

        xmltrick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), XMLTRICK.class);
                startActivity(intent);
            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SERVICE.class);
                startActivity(intent);

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SEARCH.class);
                startActivity(intent);

            }
        });

        optionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Option_menu.class);
                startActivity(intent);
            }
        });

        customview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Custom_View.class);
                startActivity(intent);
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UPBUTTONACTIVITY.class);
                startActivity(intent);
            }
        });

        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FRAGMENT.class);
                startActivity(intent);
            }
        });










        notification.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
               Intent intent = new Intent();
                PendingIntent pintent = PendingIntent.getActivities(MainActivity.this,0, new Intent[]{intent},0);

                Notification notifi = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Content Title")
                        .setContentText("Content Text gsgd dgtej")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .addAction(R.mipmap.ic_launcher,"Title1",pintent)
                        .addAction(R.mipmap.ic_launcher,"Title2",pintent)
                        .setContentIntent(pintent).getNotification();
                notifi.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager notifiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notifiManager.notify(0,notifi);
            }
        });


    }

    public void onClicktabilelayout(View view) {
        Intent intent = new Intent(getApplicationContext(), TABLE.class);
        startActivity(intent);
    }


}

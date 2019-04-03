package com.example.shakil.sujon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class TheService extends Service {

    final class TheThread implements Runnable{
        int serviceId;
        TheThread(int serviceId){
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    wait(20000);
                } catch (InterruptedException e) {

                }
            }
            stopSelf(this.serviceId);

        }
    }

    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(TheService.this, "Service Started", Toast.LENGTH_LONG).show();

        Thread thread = new Thread(new TheThread(startId));
        thread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(TheService.this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

       return null;
    }
}
package com.example.shakil.shakil;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class MyService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     //* @param name Used to name the worker thread, important only for debugging.
     */
    public MyService() {
        super("my_Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try {
                wait(20000);
            } catch (InterruptedException e) {

            }
        }
    }
}
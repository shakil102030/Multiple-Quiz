package com.example.shakil.shakil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakePhoto extends AppCompatActivity {

    ImageView image;
    Button camera;
    private static final int a = 88;
    Bitmap bitmap;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        image = (ImageView) findViewById(R.id.image);
        camera = (Button) findViewById(R.id.camera);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(count == 0) {
                  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                  startActivityForResult(intent, a);
              }
                else if(count == 1){
                  addphotosdcard(bitmap);
                  count =0;
                  camera.setText("Save Photo");
              }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == a && resultCode == RESULT_OK && data != null){

             bitmap = (Bitmap) data.getExtras().get("data");

            image.setImageBitmap(bitmap);

            count = 1;
            camera.setText("Take Photos");

        }
    }

    private void addphotosdcard(Bitmap bit){
        SimpleDateFormat amdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String name = amdf.format(new Date());

        String location = Environment.getExternalStorageDirectory().toString();
        File folder = new File(location + "/sdcard");
        folder.mkdirs();

        File image = new File(folder,name+".png");

        try {
            FileOutputStream stream = new FileOutputStream(image);
            bit.compress(Bitmap.CompressFormat.PNG, 99, stream);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }
}

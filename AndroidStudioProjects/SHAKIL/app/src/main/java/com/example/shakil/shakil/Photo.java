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

public class Photo extends AppCompatActivity {
    private ImageView camera;
    private Button button;
    private boolean image = true;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        camera = (ImageView) findViewById(R.id.camera);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 98);
                }else{
                    savephoto(bitmap);
                    image =true;
                    button.setText("Take photo");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 98 && resultCode == RESULT_OK && data!=null);
        Bitmap bitmap = (Bitmap) data.getExtras().get("abcd");
        camera.setImageBitmap(bitmap);

        image = false;
        button.setText("Save photo");
    }

     private void savephoto(Bitmap bit){
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
         String name = simpleDateFormat.format(new Date());

         String location = Environment.getExternalStorageDirectory().toString();
         File folder = new File(location,"/Folder");
         folder.mkdirs();

         File image = new File(folder,name +".png");

         try {
             FileOutputStream fileOutputStream = new FileOutputStream(image);
             bit.compress(Bitmap.CompressFormat.PNG,99,fileOutputStream);
             fileOutputStream.flush();
             fileOutputStream.close();
         } catch (FileNotFoundException e) {

         } catch (IOException e) {

         }


     }
}

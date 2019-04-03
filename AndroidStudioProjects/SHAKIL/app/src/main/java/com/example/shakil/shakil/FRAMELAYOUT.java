package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FRAMELAYOUT extends AppCompatActivity {
    LinearLayout twolayout;
    Button buttonid4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);

        twolayout = (LinearLayout) findViewById(R.id.frame_layout);
        buttonid4 = (Button) findViewById(R.id.framebuttonId);

        buttonid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(twolayout.getVisibility() == View.GONE){
                    twolayout.setVisibility(View.INVISIBLE);
                }
                else{
                    twolayout.setVisibility(View.GONE);
                }
            }
        });
    }
}

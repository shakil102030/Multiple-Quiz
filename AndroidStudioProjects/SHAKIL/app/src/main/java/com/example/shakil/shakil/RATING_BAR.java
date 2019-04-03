package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RATING_BAR extends AppCompatActivity {

    private RatingBar ratingbarid;
    TextView ratingtextid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating__bar);

        ratingbarid = (RatingBar) findViewById(R.id.ratingbarid);
        ratingtextid = (TextView) findViewById(R.id.ratingtextid);

        ratingbarid.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingtextid.setText("Value : "+rating);
            }
        });
    }
}

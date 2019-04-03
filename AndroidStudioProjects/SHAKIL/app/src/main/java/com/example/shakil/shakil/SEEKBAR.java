package com.example.shakil.shakil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SEEKBAR extends AppCompatActivity {

    private SeekBar Seekbarid;
    TextView SeekbartextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        Seekbarid = (SeekBar) findViewById(R.id.SeekbarId);
        SeekbartextId = (TextView) findViewById(R.id.SeekbartextId);

        SeekbartextId.setText("Value : " + Seekbarid.getProgress() + "/" + Seekbarid.getMax());

        Seekbarid.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SeekbartextId.setText("Value : " + progress + "/" + Seekbarid.getMax());

                //Toast.makeText(SEEKBAR.this, "onProgressChanged", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SEEKBAR.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SEEKBAR.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

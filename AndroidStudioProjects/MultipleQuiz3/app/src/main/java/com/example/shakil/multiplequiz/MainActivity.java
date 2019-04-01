package com.example.shakil.multiplequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int Request_Code = 1;
    private TextView highscore;
    private int heigest_number;
    private Spinner difficulty,foreignkey;
    private Session session;
    Button startquiz,logout;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highscore = (TextView) findViewById(R.id.HighScoreTextId);
        startquiz = (Button) findViewById(R.id.StartQuizButtonId);

        difficulty = (Spinner) findViewById(R.id.SpinnerDifficultyId);
        foreignkey = (Spinner) findViewById(R.id.Spinnerforeignkey);


        startquiz.setOnClickListener(this);

        loadnumber();

        loadDifficulty();
        loadForeignKey();


        session = new Session(this);

        if(!session.Signedin()){
            etlogout();
        }

        logout=(Button)findViewById(R.id.logoutId);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etlogout();
            }
        });


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), QuizScreen.class);

        String sDifficulty = difficulty.getSelectedItem().toString();
        intent.putExtra("sdifficulty", sDifficulty);

        int sForeignKeyId = (int) foreignkey.getSelectedItemId();
        String sForeignKey = foreignkey.getSelectedItem().toString();
        intent.putExtra("id", sForeignKeyId);
        intent.putExtra("NAME", sForeignKey);

        startActivityForResult(intent, Request_Code);
        Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(Request_Code == requestCode && resultCode == RESULT_OK){
            int number = data.getIntExtra("Result_code", 999);

            if (number > heigest_number){
                heigest_number = number;
                highscore.setText("HighScore : " + heigest_number);

                SharedPreferences sharedPreferences = getSharedPreferences("Share_preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("Value", heigest_number);
                editor.apply();
            }
        }
    }



    private void loadDifficulty(){
        String[] getdifficulty = Information.DifficultyName();
        ArrayAdapter<String> adapterdifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getdifficulty);
        adapterdifficulty.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        difficulty.setAdapter(adapterdifficulty);

    }

    private void loadForeignKey(){
        DbHelper dbH = new DbHelper(MainActivity.this);
        String[] getSt = dbH.gettingdatafromCoursetable();
        ArrayAdapter<String> adapterforeignkey = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getSt);
        adapterforeignkey.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        foreignkey.setAdapter(adapterforeignkey);

    }





    private void loadnumber(){
        SharedPreferences sharedPrefer = getSharedPreferences("Share_preferences", Context.MODE_PRIVATE);
        if (sharedPrefer.contains("Value")){
            sharedPrefer.getInt("Value", 888);
            highscore.setText("HighScore : " + heigest_number);
        }
    }





    private void  etlogout(){
        session.setSignedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, Login.class));
    }






}

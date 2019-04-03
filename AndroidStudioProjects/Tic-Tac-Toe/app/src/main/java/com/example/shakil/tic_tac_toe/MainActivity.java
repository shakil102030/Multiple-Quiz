package com.example.shakil.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView name1,name2;
    private Button button;
    private Button[][] btn = new Button[4][4];

    private boolean name = true;
    private int count;
    private int point1;
    private int point2;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = (TextView)findViewById(R.id.name1);
        name2 = (TextView)findViewById(R.id.name2);
        button = (Button)findViewById(R.id.button);


        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                String btnid ="game_"+i+j;
                int rid = getResources().getIdentifier(btnid, "id", getPackageName());
                btn[i][j]=(Button) findViewById(rid);
                btn[i][j].setOnClickListener(this);

            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
            }
        });



    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        if(name){
            ((Button)v).setText("X");
        }
        else{
            ((Button)v).setText("O");
        }

        count++;

        if(check()) {
            if (name) {
                name1win();
            } else{
                name2win();
            }
        }
        else if(count == 9){
            draw();
        }
        else{
            name = !name;
        }



    }

    private boolean check() {
        String[][] sum = new String[4][4];
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                sum[i][j] = btn[i][j].getText().toString();
            }
        }
        for(int i=1;i<4;i++){
            if(sum[i][1].equals(sum[i][2])
                    && sum[i][1].equals(sum[i][3])
                    &&!sum[i][1].equals("")){
            return true;
            }
        }

        for(int i=1;i<4;i++){
            if(sum[1][i].equals(sum[2][i])
                    && sum[1][i].equals(sum[3][i])
                    &&!sum[1][i].equals("")){
                return true;
            }
        }

        return sum[1][1].equals(sum[2][2])
                && sum[1][1].equals(sum[3][3])
                && !sum[1][1].equals("") || sum[1][3].equals(sum[2][2])
                && sum[1][3].equals(sum[3][1])
                && !sum[1][3].equals("");

    }

    private void name1win(){
        point1++;
        Toast.makeText(getApplicationContext(), "Tom wins!!", Toast.LENGTH_SHORT).show();
        update();
        resetb();
    }
    private void name2win(){
        point2++;
        Toast.makeText(getApplicationContext(), "Adam wins!!", Toast.LENGTH_SHORT).show();
        update();
        resetb();
    }

    private void update(){
        name1.setText("Tom: "+point1);
        name2.setText("Adam: "+point2);


    }

    private void draw(){
        Toast.makeText(getApplicationContext(), "Games draw!", Toast.LENGTH_SHORT).show();
        resetb();
    }
   private void resetb(){
       for(int i=1;i<4;i++){
           for(int j=1;j<4;j++){
               btn[i][j].setText("");
           }
       }
       count =0;
       name = !name;
   }

    private void resetAll(){
        point1 = 0;
        point2 = 0;
        update();
        resetb();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("point1",point1);
        outState.putInt("point2",point2);
        outState.putInt("count",count);
        outState.putBoolean("name",name);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        point1 = savedInstanceState.getInt("point1");
        point2 = savedInstanceState.getInt("point2");
        count = savedInstanceState.getInt("count");
        name = savedInstanceState.getBoolean("name");
    }
}

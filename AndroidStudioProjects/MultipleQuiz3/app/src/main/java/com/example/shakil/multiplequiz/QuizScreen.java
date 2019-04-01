package com.example.shakil.multiplequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizScreen extends AppCompatActivity {
    private TextView scoretext,questiontext,allquestiontext;
    private RadioGroup radiogroup;
    private RadioButton number1,number2,number3;
    Button confirmbutton;
    private List<Information> questionList;
    private int questionId;
    private int questionListSize;
    private int score;
    private Information getindexofquestion;
    private int count = 1;
    private long back;

    TextView difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        scoretext = (TextView) findViewById(R.id.ScoreTextId);
        questiontext = (TextView) findViewById(R.id.QuestionTextId);
        allquestiontext = (TextView) findViewById(R.id.AllQuestionTextId);
        number1 = (RadioButton) findViewById(R.id.Number1RadioButtonId);
        number2 = (RadioButton) findViewById(R.id.Number2RadioButtonId);
        number3 = (RadioButton) findViewById(R.id.Number3RadioButtonId);
        confirmbutton = (Button) findViewById(R.id.ConfirmButtonId);
        difficulty = (TextView) findViewById(R.id.DicultyTextId);

        String intent = getIntent().getStringExtra("sdifficulty");


        int fid = getIntent().getIntExtra("id",33);
        String fname = getIntent().getStringExtra("NAME");

        difficulty.setText(fname + " : " + intent);

        DbHelper dbHelper = new DbHelper(QuizScreen.this);
        questionList = dbHelper.getAllData(intent, fid+1);


        questionListSize = questionList.size();

        SetAllText();

        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(count == 1){
                      if(number1.isChecked() || number2.isChecked() || number3.isChecked()) {
                          count = 0;
                          radiogroup = (RadioGroup) findViewById(R.id.RadioGroupId);
                          RadioButton radioButton = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
                          radiogroup.clearCheck();
                          int answer = radiogroup.indexOfChild(radioButton)+1;

                          if(answer == getindexofquestion.getAnswer()){
                              score++;
                              scoretext.setText("Score : " + score);
                              switch (score){
                                  case 1:
                                      allquestiontext.setText("You have got " + (score*100)/questionListSize +"%"+" marks.");
                                      break;
                                  case 2:
                                      allquestiontext.setText("You have got " + (score*100)/questionListSize +"%"+" marks.");
                                      break;
                                  case 3:
                                      allquestiontext.setText("You have got " + (score*100)/questionListSize +"%"+" marks.");
                                      break;
                              }
                          }
                          else{
                              allquestiontext.setText("Not correct,Answer is "+getindexofquestion.getAnswer());
                          }

                          if(questionId < questionListSize){
                              confirmbutton.setText("Next");
                          }else {
                              confirmbutton.setText("Finish");
                          }
                      }
                      else {
                          Toast.makeText(QuizScreen.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                      }
                  }
                else {
                      SetAllText();
                  }
            }
        });

    }

    private void SetAllText(){
        if(questionId < questionListSize){
            getindexofquestion = questionList.get(questionId);
            allquestiontext.setText(getindexofquestion.getQuestion());
            number1.setText(getindexofquestion.getNumber1());
            number2.setText(getindexofquestion.getNumber2());
            number3.setText(getindexofquestion.getNumber3());
            questionId++;
            questiontext.setText("Question: " + questionId + "/" + questionListSize);
            confirmbutton.setText("Confirm");
            count = 1;
        }
        else{
            FinishText();
        }


    }



    private void FinishText(){
        resultcode();

        finish();

    }

    private void resultcode(){
        Intent intent = new Intent();
        intent.putExtra("Result_code", score);
        setResult(RESULT_OK, intent);
    }


    /*@Override
    public void onBackPressed() {

        if(back + 200 > System.currentTimeMillis()){
            finish();
        }
        long back = System.currentTimeMillis();
    }*/
}

package com.example.shakil.scientificcalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StartActivity extends AppCompatActivity {
    TextView calculation_variable;
    Button clear,equal,dot;

    String textcalculation = "",textanswer = "",textnumber = "",textoperator = "";
    double numbers = 0.0,total = 0.0,result = 0.0;

    NumberFormat format,longformat;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        calculation_variable = (TextView) findViewById(R.id.CalculationTextId);
        clear = (Button) findViewById(R.id.ClearButtonId);
        equal = (Button) findViewById(R.id.EqualButtonId);
        dot = (Button) findViewById(R.id.DotButtonId);

        format = new DecimalFormat("#.####");
        longformat = new DecimalFormat("0.#E0");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textcalculation = "";
                textanswer = "";
                textnumber = "";
                textoperator = "";
                numbers = 0.0;
                total = 0.0;
                result = 0.0;
                TextCalculation();

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextAnswer();
                textcalculation = "";
                textanswer = "";
                textnumber = "";
                textoperator = "";
                numbers = 0.0;
                total = 0.0;
                result = 0.0;

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textanswer.length() == 0){
                    textcalculation = "0.";
                    textnumber = "0.";
                    textanswer = "0.";
                    TextCalculation();

                }else {
                    textcalculation += ".";
                    textnumber += ".";
                    textanswer += ".";
                    TextCalculation();
                }
            }
        });


    }



    public void numbers(View view) {
        Button numbers_obj = (Button)view;

        textcalculation += numbers_obj.getText();
        textnumber += numbers_obj.getText();
        numbers = Double.parseDouble(textnumber);

        switch (textoperator){

            case "":
                total = result + numbers;
                textanswer = format.format(total).toString();
                break;
            case "+":
                total = result + numbers;
                textanswer = format.format(total).toString();
                break;
            case "-":
                total = result - numbers;
                textanswer = format.format(total).toString();
                break;
            case "X":
                total = result * numbers;
                textanswer = format.format(total).toString();
                break;
            case "/":

                try {
                    total = result / numbers;
                    textanswer = format.format(total).toString();
                }catch (Exception e){
                    textanswer = e.getMessage();
                }

                break;
        }

        TextCalculation();

    }

    public void TextCalculation(){
        calculation_variable.setText(textcalculation);

    }

    public void TextAnswer(){
        calculation_variable.setText(textanswer);

    }

    public void operators(View view) {
        Button opretors_obj = (Button)view;
        if(textanswer != ""){
            textcalculation += opretors_obj.getText();
            textoperator = opretors_obj.getText().toString();
            textnumber = "";
            result = total;
            total = 0.0;
            numbers = 0.0;
            textanswer = format.format(result).toString();
            TextCalculation();
        }
    }
}

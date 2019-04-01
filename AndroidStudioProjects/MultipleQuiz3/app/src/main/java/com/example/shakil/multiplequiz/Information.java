package com.example.shakil.multiplequiz;

public class Information {



    public static final String EASY = "Easy";
    public static final String MEDIUM = "Medium";
    public static final String HARD = "Hard";


    private String question,number1,number2,number3,difficulty;
    private int answer,id,foreignkey;
    public Information() {
    }

    public Information(String question, String number1, String number2, String number3, int answer,String difficulty,int foreignkey) {
        this.question = question;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.answer = answer;
        this.difficulty = difficulty;
        this.foreignkey = foreignkey;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getForeignkey() {
        return foreignkey;
    }

    public void setForeignkey(int foreignkey) {
        this.foreignkey = foreignkey;
    }

    public static String[] DifficultyName(){
        String[] allname = {EASY, MEDIUM, HARD};
        return allname;
    }
}
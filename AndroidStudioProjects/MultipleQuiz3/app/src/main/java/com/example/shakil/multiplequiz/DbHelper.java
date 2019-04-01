package com.example.shakil.multiplequiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;


    public static final String TAG=DbHelper.class.getSimpleName();


    private static final String Table="users";
    private static final String ID="id";
    private static final String EMAIL="Email";
    private static final String PASSWORD="Password";



    private static final String Course_Table="Courses";
    private static final String Column_id="id";
    private static final String Column_name="Course_name";


    public static final String TABLE_NAME = "Quiz";
    public static final String TABLE_ID = "Id";
    public static final String QUESTION = "Question";
    public static final String NUMBER1 = "Number1";
    public static final String NUMBER2 = "Number2";
    public static final String NUMBER3 = "Number3";
    public static final String ANSWER = "Answer";
    public static final String DIFFICULTY = "Difficulty";
    public static final String CATEGORY = "Category";

    SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String logintable = "CREATE TABLE "
                + Table + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL + " TEXT, "
                + PASSWORD + " TEXT "
                + ")";

        final String Coursetable = "CREATE TABLE "
                + Course_Table + " ( "
                + Column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Column_name + " TEXT "
                + ")";



        final String Quiztable = "CREATE TABLE "
                + TABLE_NAME + " ( "
                + TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION + " TEXT, "
                + NUMBER1 + " TEXT, "
                + NUMBER2 + " TEXT, "
                + NUMBER3 + " TEXT, "
                + ANSWER + " INTEGER, "
                + DIFFICULTY + " TEXT, "
                + CATEGORY + " INTEGER, "
                + "FOREIGN KEY(" + CATEGORY + ") REFERENCES " +
                Course_Table + " ( " + Column_id + " ) " + " ON DELETE CASCADE "
                + ")";


        db.execSQL(logintable);
        db.execSQL(Coursetable);
        db.execSQL(Quiztable);


        passingdatatoForeignkeyclass();
        DataPasstoInformationClass();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        db.execSQL("DROP TABLE IF EXISTS " + Course_Table);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);


        onCreate(db);

    }

    public void addingDatatoDatabase(String email, String password){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(EMAIL, email);

        contentValues.put(PASSWORD, password);

        long id = db.insert(Table, null, contentValues);
        db.close();
        Log.d(TAG, " User Inserted " + id);

    }

    public boolean gettingDatafromDatabase(String sEmail, String sPassword){
        db = getReadableDatabase();
        String Sql = "SELECT * FROM " + Table + " WHERE " +
                EMAIL + " = " + "'" + sEmail + "'" + " AND " + PASSWORD + " = " +  "'" + sPassword + "'";



        Cursor cursor = db.rawQuery(Sql, null);

        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();
        return false;

    }

    public void passingdatatoForeignkeyclass(){
        ForeignKey foreignKey1 = new ForeignKey("Bangla");
        addingCourseDatatoDatabase(foreignKey1);
        ForeignKey foreignKey2 = new ForeignKey("English");
        addingCourseDatatoDatabase(foreignKey2);
        ForeignKey foreignKey3 = new ForeignKey("Math");
        addingCourseDatatoDatabase(foreignKey3);

    }


    public void addingCourseDatatoDatabase(ForeignKey cnm){
//        db = getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(Column_name, cnm.getName());

        db.insert(Course_Table, null, contentValues1);


    }
    public String[] gettingdatafromCoursetable(){
        db = getReadableDatabase();
        String sq = "SELECT * FROM " + Course_Table;
        Cursor cursor1 = db.rawQuery(sq, null);
        cursor1.moveToFirst();

        String[] getdata = new String[cursor1.getCount()];

        int c = 0;

        if (cursor1.moveToFirst()){
            do {
                getdata[c] = cursor1.getString(cursor1.getColumnIndex(Column_name));
                c++;
            }while (cursor1.moveToNext());
        }
        cursor1.close();
        return getdata;
    }






    private void DataPasstoInformationClass() {
        Information information1 = new Information("Energy of Ultraviolet rays is greater than", "A.Gamma rays",
                "B.X-rays", "C.Cosmic rays", 3, Information.EASY, 1);
        DataAddtoDatabase(information1);
        Information information2 = new Information("Who defined the law of gravitaton?", "A.Newton",
                "B.Galileo", "C.Faraday", 1, Information.MEDIUM, 2);
        DataAddtoDatabase(information2);
        Information information3 = new Information("Which of the following has got more heat capacity", "A.Iron piece",
                "B.Water", "C.Gold piece", 2, Information.HARD, 2);
        DataAddtoDatabase(information3);
        Information information4 = new Information("The metal used to make lightning conductors is", "A.Iron",
                "B.Copper", "C.Zinc", 2, Information.EASY, 1);
        DataAddtoDatabase(information4);
        Information information5 = new Information("Who defined the law of gravitaton?", "A.Newton",
                "B.Galileo", "C.Faraday", 1, Information.HARD, 2);
        DataAddtoDatabase(information5);
        Information information6 = new Information("Which colour is the complementary colour of yellow?", "A.Red",
                "B.Orange", "C.Blue", 3, Information.HARD, 3);
        DataAddtoDatabase(information6);

    }

    private void DataAddtoDatabase(Information add) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(QUESTION, add.getQuestion());
        contentValues.put(NUMBER1, add.getNumber1());
        contentValues.put(NUMBER2, add.getNumber2());
        contentValues.put(NUMBER3, add.getNumber3());
        contentValues.put(ANSWER, add.getAnswer());
        contentValues.put(DIFFICULTY, add.getDifficulty());
        contentValues.put(CATEGORY, add.getForeignkey());

        db.insert(TABLE_NAME, null, contentValues);

    }
    public List<Information> getAllData(String difficulty,int f_id){
        List<Information> informationList = new ArrayList<>();
        db = getReadableDatabase();

        String tsql =DIFFICULTY + " = ? " +
                " AND " + CATEGORY +  " = ? ";

        String[] selectionARGS = new String[]{difficulty, String.valueOf(f_id)};

        Cursor cursor = db.query(TABLE_NAME, null, tsql, selectionARGS, null, null, null);


        if(cursor.moveToFirst()){

            do {
                Information information = new Information();

                information.setId(cursor.getInt(cursor.getColumnIndex(TABLE_ID)));
                information.setQuestion(cursor.getString(cursor.getColumnIndex(QUESTION)));
                information.setNumber1(cursor.getString(cursor.getColumnIndex(NUMBER1)));
                information.setNumber2(cursor.getString(cursor.getColumnIndex(NUMBER2)));
                information.setNumber3(cursor.getString(cursor.getColumnIndex(NUMBER3)));
                information.setAnswer(cursor.getInt(cursor.getColumnIndex(ANSWER)));
                information.setDifficulty(cursor.getString(cursor.getColumnIndex(DIFFICULTY)));
                information.setForeignkey(cursor.getInt(cursor.getColumnIndex(CATEGORY)));

                informationList.add(information);


            }while (cursor.moveToNext());
        }
        cursor.close();
        return informationList;

    }

}


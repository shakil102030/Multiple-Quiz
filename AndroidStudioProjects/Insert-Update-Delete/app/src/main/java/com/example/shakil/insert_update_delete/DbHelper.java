package com.example.shakil.insert_update_delete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Insert_Update_Delete";
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    SQLiteDatabase db;




    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String table = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                ID + " INTEGER PRIMARY KEY, "  +
                USERNAME + " TEXT, " +
                PASSWORD + " TEXT " +
                ")";
        db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void DataAddtoDatabase(String nm, String ps){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, nm);
        contentValues.put(PASSWORD, ps);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public String[] getData(){
        db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(sql, null);

        String[] array = new String[cursor.getCount()];

        if(cursor.moveToFirst()){
            int count = 0;
           do {
               array[count] = cursor.getString(cursor.getColumnIndex(USERNAME)) + "\n" +
                       cursor.getString(cursor.getColumnIndex(PASSWORD));
                  count++;

           }while (cursor.moveToNext());

        }

        cursor.close();
        return array;
    }

    public String Edittext(int id){
        db = getReadableDatabase();
        String DATA = "SELECT "+PASSWORD+" FROM " + TABLE_NAME + " WHERE " + ID + " = " + id;
        Cursor CURSOR = db.rawQuery(DATA,null);
        String value = "";
        if (CURSOR.moveToFirst()){
             value = CURSOR.getString(CURSOR.getColumnIndex(PASSWORD));
        }
        CURSOR.close();
        return value;
    }

    public int UpdateFunction(int id, String edittext){
        db = getWritableDatabase();
        ContentValues contentVal = new ContentValues();
        contentVal.put(PASSWORD, edittext);
        return db.update(TABLE_NAME, contentVal,ID + " = ? ", new String[]{String.valueOf(id)});

    }

    public int DeleteFunction(String password){
        db = getWritableDatabase();
        return db.delete(TABLE_NAME, PASSWORD + " = ? ", new String[]{password});
    }




}
package com.cmpundhir.cm.allwidgetsdemo.SqlLite_package.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cmpundhir.cm.allwidgetsdemo.SqlLite_package.model.Demo;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoSqlLiteHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME="Demo";
    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_EMAIL="Email";
    private static final String COLUMN_PASSWORD="Password";
    public UsersDaoSqlLiteHelper(Context context) {
        super(context,"DemoDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
                + COLUMN_EMAIL + " TEXT UNIQUE," + COLUMN_PASSWORD + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addDemo(Demo demo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, demo.getName());
        contentValues.put(COLUMN_EMAIL, demo.getEmail());
        contentValues.put(COLUMN_PASSWORD, demo.getPassword());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Demo> getallDemo(){
        List<Demo>list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                Demo demo = new Demo();
                demo.setName("Name = "+cursor.getString(0));
                demo.setEmail("Email = "+cursor.getString(1));
                demo.setPassword("Password = "+cursor.getString(2));
                list.add(demo);
            }while(cursor.moveToNext());
        }
        return list;
    }
}

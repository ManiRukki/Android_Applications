package com.example.flight_booking_0333;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.webkit.WebStorage;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Flight_Bookings.Db";
    public static final String TABLE_NAME="Flight_Booking";
    public static final String col1="Name";
    public static final String col2="Mobile";
    public static final String col3="email-id";
    public static final String col4="Designation";
    public static final String col5="College";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(Name TEXT,Mobile TEXT,Email_id TEXT,Designation TEXT,College TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String name,String mobile,String Email_id,String Designation,String College){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        contentValues.put("origin",Email_id);
        contentValues.put("destination",Designation);
        contentValues.put("date",College);

        long res=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (res== -1) return false;
        else return true;
    }

    public Integer countSearch(String search){
        int count=0;
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select count(*) from "+TABLE_NAME,new String[]{search});
        count=cursor.getCount();
        return count;

    }



    public String detailSearch(String search){
        String output="";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+ " where College =?",new String[]{search});
        while (cursor.moveToNext()){
            output+=cursor.getString(0)+"\n"+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+
                    cursor.getString(4)+"\n"+cursor.getString(5);
        }
        return output;

    }

}


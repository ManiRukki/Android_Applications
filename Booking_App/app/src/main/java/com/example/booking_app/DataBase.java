package com.example.booking_app;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.webkit.WebStorage;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Bookings.Db";
    public static final String TABLE_NAME="Flight_Booking";
    public static final String col1="Name";
    public static final String col2="Mobile";
    public static final String col3="Origin";
    public static final String col4="Destination";
    public static final String col5="Date";
    public static final String col6="Time";
    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(Name TEXT,Mobile TEXT,Origin TEXT,Destination TEXT,Date TEXT,Time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String name,String mobile,String origin,String destination,String date,String time){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        contentValues.put("origin",origin);
        contentValues.put("destination",destination);
        contentValues.put("date",date);
        contentValues.put("time",time);
        long res=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (res== -1) return false;
        else return true;
    }

    public Integer countSearch(String search){
        int count=0;
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+ " where destination =?",new String[]{search});
        while (cursor.moveToNext()){
            count+=1;
        }
        return count;

    }
    public String detailSearch(String search){
        String output="";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+ " where name =?",new String[]{search});
        while (cursor.moveToNext()){
            output+=cursor.getString(0)+"\n"+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+
                    cursor.getString(4)+"\n"+cursor.getString(5);
        }
        return output;

    }

}



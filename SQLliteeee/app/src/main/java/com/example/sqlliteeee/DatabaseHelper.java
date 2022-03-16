package com.example.sqlliteeee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "STUDENT.db";
    public static final String TABLE_NAME = "STUDENT_TABLE";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "DEPT";
    public static final String col_4 = "CGPA";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DEPT TEXT,CGPA TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name,String dept,String cgpa){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_2,name);

        contentValues.put(col_3,dept);

        contentValues.put(col_4,cgpa);

        long result =sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }

    public boolean updateData(String id,String name,String dept,String cgpa){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,id);

        contentValues.put(col_2,name);
        contentValues.put(col_3,dept);
        contentValues.put(col_4,cgpa);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID=?",new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID=?",new String[] {id});
    }



}
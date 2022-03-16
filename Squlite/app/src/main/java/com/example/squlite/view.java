package com.example.squlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class view extends AppCompatActivity {
  ListView lst1;
  ArrayList titles=new ArrayList<>();
  ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        SQLiteDatabase db=openOrCreateDatabase("Squlite", Context.MODE_PRIVATE,null);
        lst1=findViewById(R.id.lst1);
       final Cursor c=db.rawQuery("select *from records",null);

       int id=c.getColumnIndex("id");
       int name=c.getColumnIndex("name");
       int course=c.getColumnIndex("name");
       int fee =c.getColumnIndex("fee");
       titles.clear();

       arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
       lst1.setAdapter(arrayAdapter);

       final ArrayList<student>stud=new ArrayList<>();

       if (c.moveToFirst())
       {
        do {
            student stu=new student();
            stu.id=c.getString(id);
            stu.name=c.getString(name);
            stu.course=c.getString(course);
            stu.fee=c.getString(fee);
            stud.add(stu);
            titles.add(c.getString(id)+"\t"+c.getString(name)+"\t"+c.getString(course)+"\t"+c.getString(fee)+"\t");

        }while (c.moveToNext());
        arrayAdapter.notifyDataSetChanged();
        lst1.invalidateViews();

       }
       lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String aa=titles.get(position).toString();
               student stu=stud.get(position);
               Intent i2=new Intent(getApplicationContext(),edit.class);
               i2.putExtra("id",stu.id);
               i2.putExtra("name",stu.name);
               i2.putExtra("course",stu.course);
               i2.putExtra("fee",stu.fee);
               startActivity(i2);
           }
       });
    }
}
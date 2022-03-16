package com.example.squlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {
  EditText e1,e2,e3,e4;
  Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent i3=getIntent();


        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        e3=findViewById(R.id.editTextTextPersonName3);
        e4=findViewById(R.id.editTextTextPersonName4);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        String id= i3.getStringExtra("id");
        String name= i3.getStringExtra("name");
        String course= i3.getStringExtra("course");
        String fee= i3.getStringExtra("fee");
        e1.setText(id);
        e2.setText(name);
        e3.setText(course);
        e4.setText(fee);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(),view.class);
                startActivity(i4);
            }
        });


    }
    public void update()
    {
        try {
            String name=e1.getText().toString();
            String course=e2.getText().toString();
            String fee=e3.getText().toString();
            String id=e4.getText().toString();
            SQLiteDatabase db=openOrCreateDatabase("Squlite", Context.MODE_PRIVATE,null);
            String sql="update records set name =?,course=?,fee=? where id=?";
            SQLiteStatement statement= db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindString(2,course);
            statement.bindString(3,fee);
            statement.bindString(4,id);
            statement.execute();
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            e2.requestFocus();
        } catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Record updated", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete(){
        try {
            String id=e4.getText().toString();
            SQLiteDatabase db=openOrCreateDatabase("Squlite", Context.MODE_PRIVATE,null);
            String sql="delete from records where id=?";
            SQLiteStatement statement=db.compileStatement(sql);
            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();

            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");

             } catch (Exception ex) {
            Toast.makeText(this, "Record Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
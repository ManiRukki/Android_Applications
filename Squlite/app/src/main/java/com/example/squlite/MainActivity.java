package com.example.squlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inser();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), view.class);
                startActivity(i);
            }
        });
    }

    public void inser () {
        try {
            String name=ed1.getText().toString();
            String course=ed2.getText().toString();
            String fee=ed3.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("Squlite", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT ,name VARCHAR,course VARCHAR,fee VARCHAR)");

            String sql = "insert into records(name,course,fee)values(?,?,?)";
            SQLiteStatement statement= db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindString(2,course);
            statement.bindString(3,fee);
            statement.execute();
            Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(),"RecordFailed", Toast.LENGTH_SHORT).show();

        }
    }

}
package com.example.mid_term_0333;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
TextView  textView,text,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
textView=findViewById(R.id.textView);
//text=findViewById(R.id.text);

        Intent i=getIntent();
       String name = i.getStringExtra("key1");
        String course=i.getStringExtra("key2");
       Double percentage=i.getDoubleExtra("key3",0);
       // Toast.makeText(MainActivity2.this, "Name"+name+"course"+course+"percentage"+percentage, Toast.LENGTH_SHORT).show();
       textView.setText("your name is: "+name+"\nCourse is  :   "+course+"\nAttendence Percentage is:"+percentage);

    }
}
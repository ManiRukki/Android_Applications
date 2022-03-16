package com.example.mid_term_0333;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText name,course,attendance;
 Button calculate;
 String stu_name,stu_course;
 Double stu_percentage;
// Double class_strength;
    Double stu_members;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        course=findViewById(R.id.course);
        attendance=findViewById(R.id.students);
      calculate=findViewById(R.id.button);



      calculate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              stu_name=name.getText().toString();
              stu_course=course.getText().toString();
              stu_members = Double.parseDouble(attendance.getText().toString());

              stu_percentage=(stu_members/60)*100;
              Toast.makeText(MainActivity.this,"Student Percentage is "+stu_percentage, Toast.LENGTH_SHORT).show();
              Intent i=new Intent(getApplicationContext(),MainActivity2.class);
              i.putExtra("key1",stu_name);
              i.putExtra("key2",stu_course);
              i.putExtra("key3",stu_percentage);
              startActivity(i);
          }
      });
    }
}
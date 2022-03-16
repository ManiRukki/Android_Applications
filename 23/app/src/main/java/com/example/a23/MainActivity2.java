package com.example.a23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      
        TextView activity=findViewById(R.id.act1);
        Intent i=getIntent();
        Integer Number1=i.getIntExtra("key1",0);
        activity.setText(Number1.toString());

        Button button1=findViewById(R.id.button1);
        TextView textView1=findViewById(R.id.t2);
        Random myRandom1=new Random();
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 textView1.setText(String.valueOf(myRandom1.nextInt(100)));
                 Intent a=new Intent(getApplicationContext(),MainActivity3.class);
                 Integer num1=Integer.parseInt(activity.getText().toString());
                 Integer num=Integer.parseInt(textView1.getText().toString());
                 a.putExtra("key3",num1);
                 a.putExtra("key2",num);
                 startActivity(a);
             }
         });



    }
}
package com.example.a23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
   Integer ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView e1=findViewById(R.id.e1);
        TextView t1=findViewById(R.id.tt1);
        TextView t2=findViewById(R.id.tt2);

        //Intent i=getIntent();
       // Integer Number=i.getIntExtra("key1",0);

        Intent a=getIntent();
        Integer numm1=a.getIntExtra("key3",0);
        Integer numm2=a.getIntExtra("key2",0);
        int p=numm1+numm2;

        Integer n=Integer.parseInt(numm1.toString());
        Integer n1=Integer.parseInt(numm2.toString());
        Integer ab=n+n1;
        t1.setText(n.toString());
        t2.setText(n1.toString());
       e1.setText(ab.toString());


    }
}



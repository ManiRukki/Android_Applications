package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.widget.TextView;



public class MainActivity2 extends AppCompatActivity {

    TextView tv2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        tv2 = findViewById(R.id.textView2);



        Intent i = getIntent();

        String time = i.getStringExtra("key1");

        String date = i.getStringExtra("key2");

        String flav = i.getStringExtra("key3");

        String quan = i.getStringExtra("key4");

        Integer price = i.getIntExtra("key5",0);



        tv2.setText("Flavour :"+flav+"\n"+"Quantity :"+quan+"\n"+"Time :"+time+"\n"+"Date :"+date+"\n"+"Amount :"+price);



    }

}
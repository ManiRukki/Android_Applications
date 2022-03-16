package com.example.a23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        TextView textView=findViewById(R.id.t1);



        Random myRandom=new Random();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(String.valueOf(myRandom.nextInt(100)));
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                Integer Number=Integer.parseInt(textView.getText().toString());
                i.putExtra("key1",Number);
                startActivity(i);
            }
        });
    }
}
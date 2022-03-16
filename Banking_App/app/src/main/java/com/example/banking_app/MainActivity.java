package com.example.banking_app;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView results;
    EditText et1,et2;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.buttonwithdraw);

        results=findViewById(R.id.results);
        et1=findViewById(R.id.withdrawamt);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel=new NotificationChannel("BALANCE LESS THAN 5000","BALANCE LESS THAN 5000",
                    NotificationManager.IMPORTANCE_HIGH);

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n1=Integer.parseInt(et1.getText().toString());
                Integer n2=10000-n1;

                if(n2<5000){

                    NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"BALANCE LESS THAN 5000");
                    builder.setContentTitle("Low Amount");
                    builder.setContentText("Pls Maintain Minimum Balance 5000 : "+"Your Balance is:"+n2.toString());
                    builder.setSmallIcon(R.drawable.bank);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(100, builder.build());
                    results.setText("Balance Is Low"+n2.toString());

                }
                else{
                    results.setText(" "+n2.toString());
                }

            }
        });



    }
}
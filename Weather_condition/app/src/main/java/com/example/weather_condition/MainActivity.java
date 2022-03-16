package com.example.weather_condition;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button btn1;
    Integer bp;
    Double temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        Button btn1=findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                bp=Integer.parseInt(e1.getText().toString());
                temp=Double.parseDouble(e2.getText().toString());
                String message;

                int notificationId=100;
               if (bp!=null){
               message="You are Fine";
              }
              else
                  message="You Need to Consult Doctor";


                //creating variables for notification channel
                String CHANNEL_ID="MY_CH";
                String CHANNEL_NAME="my_channel";
                int importance= NotificationManager.IMPORTANCE_HIGH;

                //creating channel
                NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance);

                //creating notification manager
                NotificationManager notificationManager=(NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
               intent.putExtra("message",message);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //PendingIntent pendingIntent=new PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pendingIntent)
                        .setContentTitle("New Notification")
                        .setContentText("BP:"+bp+"\nTemp:"+temp);
                notificationManager.notify(notificationId, builder.build());
            }
        });
    }

}
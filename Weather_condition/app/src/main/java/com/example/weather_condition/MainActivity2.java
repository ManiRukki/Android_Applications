package com.example.weather_condition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t1=findViewById(R.id.t1);

        onNewIntent(getIntent());
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(100);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Bundle extras=intent.getExtras();
        if(extras !=null){
            if ((extras.containsKey("message"))){
                setContentView(R.layout.activity_main2);
                String msg=extras.getString("message");
                TextView t1=findViewById(R.id.t1);

                t1.setText("Report : "+msg);
            }
         super.onNewIntent(intent);

        }
    }
}
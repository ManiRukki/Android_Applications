package com.example.sms_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText number,txt;
   Button send;
   String num1,txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.editText);
        txt=findViewById(R.id.et1);
        send=findViewById(R.id.button);
        ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sm=SmsManager.getDefault();
              // num1=number.getText().toString();
              //txt1=txt.getText().toString();
                sm.sendTextMessage(number.getText().toString(),null,txt.getText().toString());
                Toast.makeText(getApplicationContext(), "SMS SEND", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
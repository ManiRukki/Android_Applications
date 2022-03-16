package com.example.flight_booking_0333;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText name, mobile, email_id,Designation,search;
    ImageButton date_picker;
    Button submit,find,time_picker,show;
    Spinner origin;
    Integer mobile1;
    int d, m, y, m1, d1, y1, hour, min;
    TimePicker time_Picker;
    Database mydb;
    String Name,Mobile,Date,Time,Origin,Destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.button);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        origin = findViewById(R.id.origin);
        email_id=findViewById(R.id.editText)
      //  destination = findViewById(R.id.destination);
      //  time = findViewById(R.id.time);
       // date = findViewById(R.id.date);
        // find=findViewById(R.id.button2);
        show=findViewById(R.id.button3);
        search=findViewById(R.id.editTextTextPersonName);
        mydb=new Database(MainActivity.this);
      //  ImageView date_picker = findViewById(R.id.date_picker);
      // ImageView  time_picker = findViewById(R.id.time_picker);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inser();
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int countTotal = mydb.countSearch(search.getText().toString());
                Toast.makeText(MainActivity.this,"Total Number of bookings for "+
                        search.getText().toString()+" is: "+countTotal+"",Toast.LENGTH_LONG ).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output=mydb.detailSearch(search.getText().toString());
                Toast.makeText(MainActivity.this,"Details of "+
                        search.getText().toString()+" is: "+output+"",Toast.LENGTH_LONG ).show();
            }
        });
    }

    private void inser() {
        Name=name.getText().toString();
        Mobile=mobile.getText().toString();
        email_id=getText().toString();
        Designation=destination.getSelectedItem().toString();

        if (origin.getSelectedItem()==destination.getSelectedItem()){
            Toast.makeText(MainActivity.this, "Origin and Destination Cannot be Same", Toast.LENGTH_SHORT).show();
        }
        boolean isInserted=mydb.insertData(Name,Mobile,);
        if (isInserted) Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplicationContext(),"Data Not Inserted",Toast.LENGTH_SHORT).show();;
    }

}
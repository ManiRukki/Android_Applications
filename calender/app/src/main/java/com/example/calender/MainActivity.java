package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {
  int d,m,y,m1,d1,y1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView src=findViewById(R.id.date_picker);
        Button button=findViewById(R.id.b1);
        EditText date=findViewById(R.id.date);
        TextView textView=findViewById(R.id.t1);



        Calendar c=Calendar.getInstance();
        int d=c.get(Calendar.DATE);
        int m=c.get(Calendar.MONTH);
        int y=c.get(Calendar.YEAR);
        src.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dtpicker=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        d1=dayOfMonth;
                        m1=month;

                        y1=year;
                        date.setText(dayOfMonth +"/"+(month+1) +"/" +year);
                    }
                },d,m,y);
                dtpicker.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    textView.setText("Entered Age is::"+d1+"/"+(m1+1)+"/"+y1+ "\n"+"My AGe is "+(y-y1)+"Years"+(m-m1)+"Months"+(d-d1)+"Days");
            }
        });



    }
}
package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;



import android.app.DatePickerDialog;

import android.app.TimePickerDialog;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.AutoCompleteTextView;

import android.widget.Button;

import android.widget.DatePicker;

import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.Spinner;

import android.widget.TimePicker;

import android.widget.Toast;



import java.util.Calendar;



public class MainActivity extends AppCompatActivity {



    EditText e1,e2;

    Button b1,b2,b3;

    Spinner s1;

    AutoCompleteTextView av;

    ImageButton im1,im2;

    String selectedf,selectedq;

    int d , m , y , hr , mi;

    int total=0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        e1=findViewById(R.id.editTextTextPersonName);

        e2=findViewById(R.id.editTextTextPersonName2);

        s1=findViewById(R.id.spinner);

        av=findViewById(R.id.autoCompleteTextView);

        b1=findViewById(R.id.button);

        im1=findViewById(R.id.imageButton);

        im2=findViewById(R.id.imageButton2);





        String[] flavours={"Vanilla","Chocolate","Black Forest","Black Berry","Red Velvet","Choco Vanilla","Buter Scotch"};

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,flavours);

        av.setAdapter(arrayAdapter);

        av.setThreshold(1);



        av.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedf=adapterView.getItemAtPosition(i).toString();

            }



            @Override

            public void onNothingSelected(AdapterView<?> adapterView) {



            }

        });





        ArrayAdapter arrayAdapter1=new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.quantity));

        s1.setAdapter(arrayAdapter1);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedq=adapterView.getItemAtPosition(i).toString();



                if(selectedq.equals("1Kg")){

                    total=total+100;



                }

                else{

                    total=0;



                }

                if(selectedq.equals("1.5Kg")){

                    total=total+150;



                }

                if(selectedq.equals("2Kg")){

                    total=total+200;



                }

                if(selectedq.equals("2.5Kg")){

                    total=total+250;



                }

                if(selectedq.equals("3Kg")){

                    total=total+300;



                }

            }



            @Override

            public void onNothingSelected(AdapterView<?> adapterView) {



            }

        });



        Calendar c = Calendar.getInstance();

        int dd = c.get(Calendar.DATE);

        int mm = c.get(Calendar.MONTH);

        int yy = c.get(Calendar.YEAR);

        int hh = c.get(Calendar.HOUR_OF_DAY);

        int min = c.get(Calendar.MINUTE);



        im1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {

                    @Override

                    public void onTimeSet(TimePicker timePicker, int i, int i1) {



                        hr = i;

                        mi = i1;

                        e1.setText(i+":"+i1);



                    }

                },hh,min,false);

                timePickerDialog.show();





            }

        });
        im2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker view, int i,

                                          int i1, int i2) {

                        d=i2;

                        m=i1;

                        y=i;

                        e2.setText(i2+"/"+(i1+1)+"/"+i);
                    }

                },dd,mm,yy);

                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

                datePickerDialog.show();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time=e1.getText().toString();

                String date=e2.getText().toString();

                String flav=av.getText().toString();

                String quan=selectedq;

                Integer price=total;
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);

                i.putExtra("key1",time);

                i.putExtra("key2",date);

                i.putExtra("key3",flav);

                i.putExtra("key4",quan);

                i.putExtra("key5",price);

                startActivity(i);

                Toast.makeText(getApplicationContext(), flav, Toast.LENGTH_SHORT).show();
            }

        });



















    }

}
package com.example.cakeapp;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String flavour[]={"vanilla","chocolate","black forest","black berry","red velvet","choco vanilla","butterscotch"};
    AutoCompleteTextView actv;
    TextView tv1,tv2;
    Spinner sp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView actv=findViewById(R.id.ac1);
       tv1=findViewById(R.id.textView2);

        tv2=findViewById(R.id.textView3);
        sp=findViewById(R.id.spinner);
        btn=findViewById(R.id.button);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,flavour);
        actv.setAdapter(arrayAdapter);
        actv.setThreshold(2);
        ArrayAdapter arrayAdapter1=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getTextArray(R.array.quantity));
        sp.setAdapter(arrayAdapter1);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedQuantity=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void selectdate(View view) {
        final Calendar c=Calendar.getInstance();
        final int mYear=c.get(Calendar.YEAR);
        final int mMonth=c.get(Calendar.MONTH);
        final int mDate=c.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                tv1.setText(i2+"/"+(i1+1)+"/"+i);
            }
        },mYear,mMonth,mDate);
        datePickerDialog.show();

    }

    public void selecttime(View view) {
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR);
        int min=c.get(Calendar.MINUTE);
        int sec=c.get(Calendar.SECOND);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                tv2.setText(i+":"+i1);
            }
        },hour,min, false);
        timePickerDialog.show();
    }

    public void display(View view) {
      //  Toast.makeText(getApplicationContext(), "chocolate"+"\none_kg"+"\n11-01-21"+"\n01:55", Toast.LENGTH_SHORT).show();
   //     Toast.makeText(getApplicationContext(), "Flavour "+actv.getText().toString() +"\nQuantity "+sp.getSelectedItem().toString() +"\nDate "+tv1.getText().toString() +"\nTime "+tv2.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Flavour "+actv.getText().toString()+"\nQuantity "+sp.getSelectedItem().toString()+"\nDate "+tv1.getText().toString()+"\nTime "+tv2.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
//hero kollesh gud n8 mowa
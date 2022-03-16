package com.example.sharedpreferencdes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
     EditText ed1,ed2,ed3;
     Spinner s1;
     Button b1;
    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES="MyPrefs";
    public static final String Name="name_key";
    public static final String Password="pass_key";
    public static final String Tickets="MyTickets";
    public static final String Type="MyType";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.editTextTextPersonName);
        ed2=findViewById(R.id.editTextTextPersonName2);
        ed3=findViewById(R.id.editTextTextPersonName3);
        s1=findViewById(R.id.spinner);
        b1=findViewById(R.id.button3);

        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        ArrayAdapter type=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getTextArray(R.array.types));
        s1.setAdapter(type);
        ed1.setText(sharedPreferences.getString(Name,null));
        String name=sharedPreferences.getString(Name,null);
        ed3.setText(sharedPreferences.getString(Name,null));
        String password=sharedPreferences.getString(Name,null);
        if (name!=null && password!=null){
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(Name,ed1.getText().toString());
                editor.putString(Tickets,ed2.getText().toString());
                editor.putString(Type, s1.getSelectedItem().toString());
                editor.commit();

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });

    }
}
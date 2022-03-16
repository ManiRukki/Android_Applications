package com.example.sharedpreferencdes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView t2;
    Button b2;

    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES="MyPrefs";
    public static final String Name="name_key";
    public static final String Password="pass_key";
    public static final String Tickets="MyTickets";
    public static final String Type="MyType";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t2=findViewById(R.id.textView);
        b2=findViewById(R.id.button2);
        sharedPreferences=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        String name=sharedPreferences.getString(Name,null);
        String pass=sharedPreferences.getString(Password,null);
        String No_of_Tickets=sharedPreferences.getString(Tickets,null);
        String Type_Tickets=sharedPreferences.getString(Type,null);
        if (name!=null && No_of_Tickets!=null && Type_Tickets!=null){
            t2.setText("Name: "+name+"Pass is XXXXXX"+"\nNumber Of Tickets Booked: "+No_of_Tickets+"\nType of Tickets Bookeed :"+Type_Tickets);

        }
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.clear()
                        .commit();
                finish();
            //    Toast.makeText(getApplicationContext(),"LogOut", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
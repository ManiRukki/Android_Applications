package com.example.fragmentapp_0333;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textView);


    }


    public void show(View view) {
        BlankFragment fragment1;
        BlankFragment2 fragment2;


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();



        if(view == findViewById(R.id.img1)){

            tv.setText("This Item Tells Us:" +"\n"+
                    "The greatest glory in living lies not in never falling, but in rising every time we fall.");



        }
        if(view == findViewById(R.id.img2)){

            tv.setText("This Item Tells Us:" +"\n"+
                    "The way to get started is to quit talking and begin doing.");

        }
        if(view == findViewById(R.id.img3)){

            tv.setText("This Item Tells Us:" +"\n"+
                    "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.");


        }
        if(view == findViewById(R.id.img4)){

            tv.setText("This Item Tells Us:" +"\n"+
                "If life were predictable it would cease to be life, and be without flavor.");

        }

    }
}

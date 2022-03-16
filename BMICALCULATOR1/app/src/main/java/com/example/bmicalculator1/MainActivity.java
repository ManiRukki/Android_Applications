package com.example.bmicalculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton,radioButton1;
    TextView textView,fresult,fit;
    EditText text_height,text_weight;
    Button button,empty;
    Double w,h,r;

    String checkheight,checkweight,fitt;
    int radioId,radioId1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup=findViewById(R.id.radioGroup);
        RadioGroup radioGroup12=findViewById(R.id.radioGroup1);
        EditText text_height=findViewById(R.id.height);
        EditText text_weight=findViewById(R.id.weight);
        TextView fresult=findViewById(R.id.result);
        TextView fitness=findViewById(R.id.fit);
        Button button=findViewById(R.id.button);
        Button empty=findViewById(R.id.empty);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                int radioId1 = radioGroup12.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                radioButton1 = findViewById(radioId1);
                checkheight = radioButton.getText().toString();
                checkweight = radioButton1.getText().toString();
                h = Double.parseDouble(text_height.getText().toString());
                w = Double.parseDouble(text_weight.getText().toString());

                if (checkheight.equals("m") && checkweight.equals("kgs")) {

                    r = w / (h * h);
                    fresult.setText(r.toString());
                } else if (checkheight.equals("m") && checkweight.equals("lbs")) {
                    w = w * 0.45359237;
                    r = w / (h * h);
                    fresult.setText(r.toString());
                } else if (checkheight.equals("cm") && checkweight.equals("kgs")) {
                    h=h/100;
                    r = w /( h * h) ;
                    fresult.setText(r.toString());
                } else if (checkheight.equals("cm") && checkweight.equals("lbs")) {
                    w = w * 0.45359237;
                    h=h/100;
                    r = w /( h * h);
                    fresult.setText(r.toString());
                } else if (checkheight.equals("feet") && checkweight.equals("kgs")) {
                    h = h / 3.281;
                    //h=h*12;(if the height is feet and lbs this step and below commented lines will be used)
                    r = (w / (h * h));
                    //r = r * 703;
                    fresult.setText(r.toString());
                } else if (checkheight.equals("feet") && checkweight.equals("lbs")) {
                    w = w * 0.45359237;
                    h = h / 3.281;
                    r = w / (h * h);
                    fresult.setText(r.toString());
                }
                if (r < 18.5) {
                    fitt = "Underweight";
                    fitness.setText(fitt.toString());
                } else if (r >= 18.5 && r <= 25.0) {
                    fitt = "HealthyRange";
                    fitness.setText(fitt.toString());
                } else if (r > 25.0) {
                    fitt = "OverWeight";
                    fitness.setText(fitt.toString());
                }
            }
        });

       empty.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               text_height.setText(null);
               text_weight.setText(null);
               fitness.setText(null);
               fresult.setText(null);

           }
       });
    }
}
package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_animation);

                button.startAnimation(animation);
            }
        });
    }
}
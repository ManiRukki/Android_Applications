package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText url;
Button b1,b2;
RatingBar ratingBar;
WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       url=findViewById(R.id.ed1);
       b1=findViewById(R.id.b1);
       b2=findViewById(R.id.b2);
       ratingBar=findViewById(R.id.rating);
       webView=findViewById(R.id.web);
       t.loadUrl();

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Url=url.getText().toString();
               Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
               startActivity(intent);
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
           String rating="MovieRating is"+ratingBar.getRating();
           Toast.makeText(MainActivity.this, "Rating is"+rating, Toast.LENGTH_SHORT).show();
           }
           }
       );
    }
}
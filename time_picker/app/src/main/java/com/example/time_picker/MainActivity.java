package com.example.time_picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsmenu(Menu M)
    {
        getMenuInflater().inflate(menu.menu,M);
        if (M instanceof MenuBuilder)
            M.setOp
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem M)
    {
        switch (M.getItemId())
        {
            case R.id.M1:
                Toast.makeText(this,"Search is Selected",Toast.LENGTH_LONG).show();
        }
    }
}

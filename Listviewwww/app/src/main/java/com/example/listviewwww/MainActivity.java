package com.example.listviewwww;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        EditText editText=findViewById(R.id.editTextTextPersonName);
        ListView listView=findViewById(R.id.list);

        ArrayList items=new ArrayList();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,items);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemText=editText.getText().toString();
                if (!(itemText.equals("")))
                {
                    items.add(itemText);
                    arrayAdapter.notifyDataSetChanged();
                    editText.setText(null);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter",Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item is removed is :",Toast.LENGTH_LONG).show();
                arrayAdapter.notifyDataSetChanged();
                return false;


            }
        });
    }
}
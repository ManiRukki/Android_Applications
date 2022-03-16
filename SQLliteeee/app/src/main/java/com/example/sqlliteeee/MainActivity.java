package com.example.sqlliteeee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
Button b1,b2,b3,b4;
String id,name,dept,cgpa;
DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ed1=findViewById(R.id.editTextTextPersonName);
       ed2=findViewById(R.id.editTextTextPersonName2);
       ed3=findViewById(R.id.editTextTextPersonName3);
       ed4=findViewById(R.id.editTextTextPersonName4);
       b1=findViewById(R.id.button);
       b2=findViewById(R.id.button2);
       b3=findViewById(R.id.button3);
       b4=findViewById(R.id.button4);
       mydb=new DatabaseHelper(MainActivity.this);
       insertData();
       getAllData();
       updateData();
       deleteData();
    }



    public void insertData() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =mydb.insertData(ed1.getText().toString(), ed3.getText().toString(),ed4.getText().toString());
                if (isInserted ==true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getAllData() {
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=mydb.getAllData();
                if(res.getCount() ==0) {
                   showMessage("Error","NoDataFound");
                    // showMessage("Error,No data Found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Dept :"+res.getString(2)+"\n");
                    buffer.append("Cgpa :"+res.getString(3)+"\n");
                }
            }
        });

    }
    public void showMessage(String title,String Message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private void deleteData() {
   b3.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Integer deleted= mydb.deleteData(ed1.getText().toString());
           if(deleted >  0)
               Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();

           else
               Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
       }

   });
    }

    private void updateData() {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate=mydb.updateData(ed1.getText().toString(),ed2.getText().toString(), ed3.getText().toString(),ed4.getText().toString());
                if (isUpdate==true)
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
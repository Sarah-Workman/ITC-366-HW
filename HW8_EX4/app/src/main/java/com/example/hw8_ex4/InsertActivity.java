package com.example.hw8_ex4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;



public class InsertActivity extends AppCompatActivity {
   private Database dbManager;
    final String NEW_FORMAT = " hh:mm";
    final String DATE_FORMAT = " mm/dd/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new Database(this);
        setContentView(R.layout.insert);
        Log.w("Insert Activity", "Create");


    }


    public void ADD(View view) {
        //get Text
        Log.w("Insert Activity", "Add");

        EditText etTODO = findViewById(R.id.todo_insert);
        EditText etDate = findViewById(R.id.date_insert);
        EditText etTime = findViewById(R.id.time_insert);
        String TODO = etTODO.getText().toString();
        String date = etDate.getText().toString();
        String time= etTime.getText().toString();






          TODO todos = new TODO(0, TODO, time, date);
             dbManager.insert(todos);
            Log.w("Insert Activity: ", "Item added to database");

           Toast.makeText(this, "TODO has been added", Toast.LENGTH_SHORT).show();

    }


    public void BACK(View view) {
        this.finish();
    }
}

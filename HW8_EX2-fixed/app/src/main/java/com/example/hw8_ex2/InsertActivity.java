package com.example.hw8_ex2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    private DataBaseManager dbManager;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DataBaseManager(this);
        setContentView(R.layout.insert_add);
    }

    public void Insert(View view) {
        Log.w("InsertActivity", "Insert Selected");
        EditText fNameET = findViewById(R.id.firstNameET);
        EditText emET = findViewById(R.id.eMailET);
        String Name = fNameET.getText().toString();
        String eMail = emET.getText().toString();


        //insert into database
        try{
            Friends friends = new Friends(0, Name, eMail);
            dbManager.insert(friends);
            Toast.makeText(this, "You added a new friend", Toast.LENGTH_SHORT).show();
        }
        catch(NumberFormatException nfe){
            Toast.makeText(this, "Email Error", Toast.LENGTH_SHORT).show();
        }

        //clear data
        fNameET.setText("");
        emET.setText("");


    }

    public void goBack(View view) {
        Log.w("InsertActivity", "Back to Home");

        this.finish();
    }
}

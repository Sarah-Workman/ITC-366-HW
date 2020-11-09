package com.example.hw8_ex3;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    private DataBaseManager dbManager;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.insert);
    }


    public void ADD(View view) {
        Log.w("InsertActivity", "Insert Selected");
        EditText newTODO = findViewById(R.id.todoET);
        String Ntodo = newTODO.getText().toString();



        //insert into database
        try{
            TOdo todos = new TOdo(0, Ntodo);
            dbManager.insert(todos);
            Toast.makeText(this, "You Added a New Item to Your TO DO List", Toast.LENGTH_SHORT).show();
        }
        catch(NumberFormatException nfe){
            Toast.makeText(this, "TO DO Error", Toast.LENGTH_SHORT).show();
        }

        //clear data
        newTODO.setText("");


    }

    public void BACK(View view) {
        Log.w("InsertActivity", "Insert Selected");
        this.finish();


    }
}

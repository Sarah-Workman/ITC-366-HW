package com.example.hw8_ex3;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    private DataBaseManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DataBaseManager( this );
        setContentView(R.layout.insert);



    }

    public void add(@Nullable View view) {

        Log.w("InsertActivity", "Insert Selected");
        EditText newTODO = findViewById(R.id.todoET);
        String Ntodo = newTODO.getText().toString();



        //insert into database

            TOdo todo = new TOdo(0, Ntodo);
            dbManager.insert(todo);
            Toast.makeText(this, "You Added a New Item to Your TO DO List", Toast.LENGTH_SHORT).show();

        //clear data
        newTODO.setText("");


    }

    public void BACK(View view) {
        Log.w("InsertActivity", "Insert Selected");
        this.finish();


    }
}
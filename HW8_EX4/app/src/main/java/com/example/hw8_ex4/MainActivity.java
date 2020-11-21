package com.example.hw8_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




            addTOHOME();


    }



    private void addTOHOME() {

        Intent addtoHome = new Intent(this, addTOhome.class);
        this.startActivity(addtoHome);
    }
}//end of Main
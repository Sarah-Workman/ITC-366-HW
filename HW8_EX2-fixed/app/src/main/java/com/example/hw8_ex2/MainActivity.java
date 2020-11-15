package com.example.hw8_ex2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseManager dbManager = new DataBaseManager(this);
        ArrayList<Friends> friends = dbManager.selectAll();


        for(int i=0; i <= friends.size(); i++){
            addTOHOME();

        }
    }

    
    public void addTOHOME(){
        Log.w("MainActivity", "Inside on pause");
        Intent addtoHome = new Intent(this, addTOHome.class);
        this.startActivity(addtoHome);
    }
}//end of Main
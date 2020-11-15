package com.example.hw8_ex3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private EditText etx;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> todos;
    private DataBaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseManager dbManager = new DataBaseManager(this);


        ArrayList<TOdo> todos = dbManager.selectAll();


        for(int i=0; i < todos.size(); i++){
            addTOHOME();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }//end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu has options

        int id = item.getItemId();

        switch (id) {
            case R.id.todo_add:
                Log.w("MainActivity", "Add Selected");
                Intent intentInsert = new Intent(this, Insert.class);
                this.startActivity(intentInsert);
                return true;

            case R.id.todo_delete:
                Log.w("MainActivity", "Delete Selected");
                Intent intentDelete = new Intent(this, DeleteActivity.class);
                this.startActivity(intentDelete);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }








    }

    public void addTOHOME(){
        Log.w("MainActivity", "Inside on pause");
        Intent addtoHome = new Intent(this, addTOHome.class);
        this.startActivity(addtoHome);
    }
}
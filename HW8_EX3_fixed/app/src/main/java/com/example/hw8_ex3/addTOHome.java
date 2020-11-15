package com.example.hw8_ex3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addTOHome extends AppCompatActivity {
    private DataBaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("addTOHome", "intent started inside create");
        dbManager = new DataBaseManager(this);
        setContentView(R.layout.activity_main);



        updateView();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        Log.w("addTOHome", "Menu added to mainActivity.xml");
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
    private void updateView() {

        ArrayList<TOdo> todos = dbManager.selectAll();

        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        Cursor data = dbManager.getListContents();
        Log.w("addTOHome", "Inside updateView()");
        RadioGroup group = new RadioGroup(this);
        if(data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        }else{ for(TOdo todo : todos) {
            RadioButton rb = new RadioButton(this);
            rb.setId(todo.getId());
            rb.setText(todo.toString());
            group.addView(rb);
        }

            scrollView.addView(group);
            layout.addView(scrollView);



            setContentView(layout);

    }

    }
}




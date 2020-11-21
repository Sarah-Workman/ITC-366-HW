package com.example.hw8_ex4;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addTOhome extends AppCompatActivity {
    private Database dbManager;
    private final int MAX = 50;
    private final int MIN = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new Database(this);

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
            case R.id.addBtn:
                Log.w("MainActivity", "Add Selected");
                Intent intentInsert = new Intent(this, InsertActivity.class);
                this.startActivity(intentInsert);
                return true;

            case R.id.editBtn:
                Log.w("addTOhome", "Edit Selected");
                Intent edit = new Intent(this, EditActivity.class);
                this.startActivity(edit);
                return true;

            case R.id.deleteBtn:
                Log.w("MainActivity", "Delete Selected");
                Intent intentDelete = new Intent(this, Delete.class);
                this.startActivity(intentDelete);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("ResourceAsColor")
    public void updateView() {

        ArrayList<TODO> todos = dbManager.selectAll();
        int i = 0;
        int b = 0;

        //create textviews and add to layout
        if (todos.size() > MIN) {
            ScrollView scrollview = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(todos.size());
            grid.setColumnCount(2);

            //Create Arrays of Components
            TextView[] ids = new TextView[todos.size()];
            TextView[][] dueDates = new TextView[todos.size()][MAX];

            //Retrieve the width of the screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;

            //Create the textView for the todo


            for (TODO todo : todos) {
                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + todo.getId());

                dueDates[i][b] = new TextView(this);


                dueDates[i][b].setText(todo.ListView());


                dueDates[i][b].setId(todo.getId());

                grid.addView(ids[i], width / 10,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(dueDates[i][b], (int) (width * .90),
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                i++;

            }

            scrollview.addView(grid);
            setContentView(scrollview);
        }
            Cursor data = dbManager.getListContents();
            if (data.getCount() > todos.size()) {
                updateView();
                Log.w("addTOhome", " updated complete, you should see all TODO items");

            }

        }



    }









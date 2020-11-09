package com.example.hw8_ex3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent intentInsert = new Intent(this, InsertActivity.class);
                this.startActivity(intentInsert);
                return true;

            case R.id.todo_delete:
                Log.w("MainActivity", "Delete Selected");
                Intent intentDelete = new Intent(this, DeleteActivity.class);
                this.startActivity(intentDelete);
                return true;

            case R.id.todo_view:
                Intent intentView = new Intent(this, TOdo.class);
                this.startActivity(intentView);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
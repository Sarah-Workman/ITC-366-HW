package com.example.hw8_ex2;


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

        switch(id){
            case R.id.item_add:
            Log.w("MainActivity", "Add Selected");
                Intent intentAdd = new Intent(this, InsertActivity.class);
                this.startActivity(intentAdd);
                return true;

            case R.id.item_delete:
             Log.w("MainActivity", "Delete Selected");
             Intent intentDelete = new Intent(this, DeleteActivity.class);
             this.startActivity(intentDelete);
             return true;

            case R.id.item_update:
            Log.w("MainActivity", "Update Selected");
            Intent intentUpdate = new Intent(this, EditActivity.class);
            this.startActivity(intentUpdate );
            return true;

            default:
                return super.onOptionsItemSelected(item);


        }//end of switch
    }
}//end of Main
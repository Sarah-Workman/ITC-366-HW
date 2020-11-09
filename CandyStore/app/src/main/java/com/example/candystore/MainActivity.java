package com.example.candystore;


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
    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }//end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu has options
        int id = item.getItemId();

        switch(id){
            case R.id.action_add:
                Log.w("MainActivity", "Add Selected" );
                Intent insertIntent = new Intent(this, InsertActivity.class);
                this.startActivity(insertIntent);
                return true;

             case R.id.action_delete:
                Log.w("MainActivity", "Delete Selected");
                Intent deleteIntent = new Intent(this, Delete.class);
                this.startActivity(deleteIntent);
                return true;

            case R.id.action_update:
                Log.w("MainActivity", "Updated Selected");
                Intent updateIntent = new Intent(this, Update.class);
                this.startActivity(updateIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }//end of swtich




    }//end of onOptionsItemSelected
}//end of Main
package com.example.hw8_ex2;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addTOHome extends AppCompatActivity {
    private DataBaseManager dbManager;
    public RadioButton id;


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


        }//end
    }
    private void updateView() {

        ArrayList<Friends> friends = dbManager.selectAll();

        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        Cursor data = dbManager.getListContents();
        Log.w("addTOHome", "Inside updateView()");
        RadioGroup group = new RadioGroup(this);


         if (data.getCount() <= 0) {
          Toast.makeText(this, "You Have No Friends. Add New Friends!", Toast.LENGTH_LONG).show();

         } else{ for(Friends friend : friends) {
            RadioButton rb = new RadioButton(this);
            rb.setId(friend.getId());
            rb.setText(friend.toString());
            group.addView(rb);
            Toast.makeText(this, "You have " + data.getCount() + " friend(s)! ", Toast.LENGTH_LONG).show();
        }

            scrollView.addView(group);
            layout.addView(scrollView);



            setContentView(layout);

        }

    }

}
package com.example.hw8_ex4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

public class Delete extends AppCompatActivity {
    private Database dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new Database(this);
        setContentView(R.layout.delete_main);
        updateView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.delete_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.back_icon:
                Intent home = new Intent(this, MainActivity.class);
                this.startActivity(home);
                Log.w("Delete", "Back Button Selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateView() {
        ArrayList<TODO> todos = dbManager.selectAll();
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup group = new RadioGroup(this);
        for (TODO dueTO : todos) {
            RadioButton rb = new RadioButton(this
            );
            rb.setId(dueTO.getId());
            rb.setText(dueTO.toString());
            group.addView(rb);
        }
        //inside of main still
        //set up event handling
        RadioButtonHandler rbh = new RadioButtonHandler();
        group.setOnCheckedChangeListener(rbh);

        //create a back button


        //add a back button at the bottom of the View
        scrollView.addView(group);
        layout.addView(scrollView);

        setContentView(layout);
    }

    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            dbManager.deleteById(checkedId);
            Toast.makeText(Delete.this, "TODO item deleted",
                    Toast.LENGTH_SHORT).show();

            // update screen
            updateView();
        }
    }
}

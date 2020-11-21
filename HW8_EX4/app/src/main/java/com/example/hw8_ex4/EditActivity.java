package com.example.hw8_ex4;

        import android.graphics.Point;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.Menu;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.GridLayout;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    private Database dbManager;
    private EditText[][] TODOitems;

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
    private void updateView() {

        ArrayList<TODO> todos = dbManager.selectAll();

        //Creating a ScrollView and GridLayout
        if(todos.size() >0){
            ScrollView scrollView = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(todos.size());
            grid.setColumnCount(5);
            //Create Arrays of Components
            TextView[] ids = new TextView[todos.size()];
            EditText[][] TODOitems = new EditText[todos.size()][3];
            Button[] buttons = new Button[todos.size()];
            ButtonHandler bh = new ButtonHandler();

            //Retrieve the width of the screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;

            //Create the textView for the friend ID
            int i = 0;


            for(TODO todo : todos){
                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + todo.getId());


                //Create the EditText for the Friend's first name,
                // last name, and emai
                TODOitems[i][0] = new EditText(this);
                TODOitems[i][1] = new EditText(this);
                TODOitems[i][2] = new EditText(this);
                TODOitems[i][0].setText(todo.getTODO());
                TODOitems[i][1].setText("" + todo.getDate());
                TODOitems[i][2].setText("" + todo.getTime());


                TODOitems[i][0].setId(10 * todo.getId());
                TODOitems[i][1].setId(10 * todo.getId() + 1);
                TODOitems[i][2].setId(10 * todo.getId() + 2);


                //Create the button
                buttons[i] = new Button(this);
                buttons[i].setText("Update");
                buttons[i].setId(todo.getId());

                //Setup the EventHandler
                buttons[i].setOnClickListener(bh);

                //add the elements the the view.
                grid.addView(ids[i], width / 10,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(TODOitems[i][0], (int) (width * .25),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(TODOitems[i][1], (int) (width * .20),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(TODOitems[i][2], (int) (width * .20),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(buttons[i], (int) (width * .35),
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                i++;
            }
            scrollView.addView(grid);
            setContentView(scrollView);
        }
    }




    private class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            EditText todoET = findViewById(10 * id);
            EditText dateET = findViewById(10 * id + 1);
            EditText timeET = findViewById(10 * id + 2);


            String TODO = todoET.getText().toString();
            String DATE = dateET.getText().toString();
            String TIME = timeET.getText().toString();

            //update Friends in the database
            try{
                dbManager.updateById(id, TODO, DATE, TIME);
                Toast.makeText(EditActivity.this, "TODO updated",
                        Toast.LENGTH_SHORT).show();


                //update screen
                updateView();
            }catch (NumberFormatException nfe) {
                Toast.makeText(EditActivity.this,
                        "Email Error", Toast.LENGTH_LONG).show();
            }

        }
    }
}


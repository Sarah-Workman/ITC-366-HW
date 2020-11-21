package com.example.hw8_ex4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private Database dbManager;
    private static final String DATABASE_NAME = "dueDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_dueTODO = "dueTODO";
    private static final String ID = "id";
    private static final String TODO = "TODO";
    private static final String DATE = "Date";
    private static final String TIME = "time";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreate = " create table " + TABLE_dueTODO + " (" + ID;
        sqlCreate += " INTEGER PRIMARY KEY AUTOINCREMENT, " + TODO;
        sqlCreate += " TEXT, " + DATE;
        sqlCreate += " TEXT, " + TIME;
        sqlCreate += " TEXT ) ";
        Log.w("Database", "Table created");

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old table if it exists
        db.execSQL("drop table if exists " + TABLE_dueTODO);
        // Re-create tables
        onCreate(db);

    }


    public void insert (TODO todos){
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_dueTODO;
        sqlInsert += " values( null, '" + todos.getTODO() + "', '" +  todos.getTime() + "', '" + todos.getDate() + "' )";

        db.execSQL( sqlInsert );
        db.close( );

    }

    public ArrayList<TODO> selectAll() {
        String sqlQuery = "select * from " + TABLE_dueTODO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<TODO> todos = new ArrayList<>();
        while (cursor.moveToNext()) {
            TODO currentTODO
                    = new TODO(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            todos.add(currentTODO);

        }

        db.close();
        return todos;
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase( );
        db.isOpen();
        String sqlDelete = " delete from " + TABLE_dueTODO;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL( sqlDelete );
        db.close( );
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_dueTODO, null);
        return data;
    }

    public void updateById(int id, String todo, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.isOpen();
        String sqlUpdate = " update " + TABLE_dueTODO;
        sqlUpdate += " set " + TODO + " = ' " + todo + " ', ";
        sqlUpdate += DATE + " = ' " + date + " ', " + TIME + " =' " + time + " ' ";
        sqlUpdate += " where " + ID + " = " + id;

        db.execSQL( sqlUpdate );
        db.close( );
    }
}




package com.example.hw8_ex3;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseManager extends SQLiteOpenHelper {
    private DataBaseManager dbManager;

    private static final String DB_NAME = "todoDB" ;
    private static final int DB_VERSION = 1;
    private static final String TABLE_TODO = "todo" ;
    private static final String ID = "id";
    private static final String TODOITEM = "Item";

    public DataBaseManager(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Build onCreate that will build our database
        String sqlCreate = "create table " + TABLE_TODO + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + TODOITEM + "text )";


        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_TODO );
        // Re-create tables
        onCreate( db );

    }
    public void insert (TOdo todos){
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_TODO;
        sqlInsert += " values( null, '" + todos.getTODO() + "' )";

        db.execSQL( sqlInsert );
        db.close( );

    }

    public ArrayList<TOdo> selectAll() {
        String sqlQuery = "select * from " + TABLE_TODO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<TOdo> todos = new ArrayList<TOdo>();
        while (cursor.moveToNext()) {
            TOdo currentTODO = new TOdo(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));
            todos.add(currentTODO);

        }

        db.close();
        return todos;
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlDelete = "delete from " + TABLE_TODO;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL( sqlDelete );
        db.close( );
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_TODO, null);
        return data;
    }

}

package com.example.hw8_ex2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseManager extends SQLiteOpenHelper {
    private DataBaseManager dbManager;

    private static final String DATABASE_NAME = "friendsDB" ;
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_FRIENDS = "friends" ;
    private static final String ID = "id";
    private static final String FIRSTNAME = "First Name";
    private static final String LASTNAME = "Last Name";
    private static final String EMAIL = "Email";

    public DataBaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Build onCreate that will build our database
        String sqlCreate = "create table " + TABLE_FRIENDS + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + FIRSTNAME;
        sqlCreate += " text, " + LASTNAME;
        sqlCreate +=  " text, " + EMAIL + " text )" ;

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_FRIENDS );
        // Re-create tables
        onCreate( db );

    }
    public void insert (Friends friends){
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_FRIENDS;
        sqlInsert += " values( null, '" + friends.getFirstName( );
        sqlInsert += "', '" + friends.getLastName( );
        sqlInsert += "', '" + friends.getEmail( ) + "' )";

        db.execSQL( sqlInsert );
        db.close( );

    }

    public ArrayList<Friends> selectAll() {
        String sqlQuery = "select * from " + TABLE_FRIENDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<Friends> friends = new ArrayList<>();
        while (cursor.moveToNext()) {
            Friends currentCandy
                    = new Friends(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3));
            friends.add(currentCandy);

        }

        db.close();
        return friends;
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlDelete = "delete from " + TABLE_FRIENDS;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL( sqlDelete );
        db.close( );
    }

    public void updateById(int id, String Fname, String Lname, String Email) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sqlUpdate = "update " + TABLE_FRIENDS;
        sqlUpdate += " set " + FIRSTNAME + " = '" + Fname + "', ";
        sqlUpdate += LASTNAME + " = '" + Lname + "', ";
        sqlUpdate += EMAIL + " = '" + Email + "'";
        sqlUpdate += " where " + ID + " = " + id;

        db.execSQL( sqlUpdate );
        db.close( );
    }
}



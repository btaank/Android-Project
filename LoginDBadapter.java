package com.example.bharti.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * Created by bharti on 10/8/2016.
 */

public class LoginDBadapter {

    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 2;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "USERNAME  text,PASSWORD text,EMAIL text,PHONE text); ";
    static final String GROCERY_LIST_CREATE = "create table " + "GROCERY" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "NAME  text, QUANTITY text); ";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;

    public LoginDBadapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public LoginDBadapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String userName, String password,String email, String phone) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        newValues.put("EMAIL",email);
        newValues.put("PHONE",phone);
        db.insert("LOGIN", null, newValues);
    }

    public void insertGrocery(String Name, String quantity) {
        ContentValues newValues = new ContentValues();
        newValues.put("NAME", Name);
        newValues.put("QUANTITY", quantity);

        db.insert("GROCERY", null, newValues);
    }
    private String Name ;
    private String quantity ;

    public void setGname(String gName){
        this.Name = gName;
    }

    public String getGroceryName(){
        return Name;
    }
    public String getGroceryQuantity(){
        return quantity;
    }
    public void setgQuantity(String gQuantity){
        this.quantity = gQuantity;
    }

    public int deleteEntry(String UserName) {

        String where = "USERNAME=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where,
                new String[] { UserName });
        return numberOFEntriesDeleted;
    }

    public String getSingleEntry(String userName){
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?",
                new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;

    }
 /*   public String getUsername( ) {

        Cursor c = db.query("LOGIN", null, "USERNAME=?", null, null , null, null);
        if (c.getCount() < 1) {
            c.close();
            return "NOT EXIST";
        }
        c.moveToFirst();
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append(c.getString(c.getColumnIndex("USERNAME")));
        }
        return buffer.toString();

    }
*/    public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[] { userName });
    }
}

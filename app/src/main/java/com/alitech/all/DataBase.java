package com.alitech.all;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    private static final String DataBase_Name = "DataBaseApp";
    private static final int version = 1;
    private static final String Table_Name = "Users";
    private static final String userID = "ID";
    private static final String fullName = "FullName";
    private static final String userName = "UserName";
    private static final String Password = "Password";
    public DataBase(@Nullable Context context) {
        super(context, DataBase_Name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users (ID INTEGER PRIMARY KEY AUTOINCREMENT, FullName VARCHAR(255)NOT NULL UNIQUE, UserName TEXT NOT NULL UNIQUE, Password VARCHAR(255) NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS Users");
        onCreate(db);
    }
    public long insertData(String fullname, String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.fullName, fullname);
        contentValues.put(this.userName, username);
        contentValues.put(this.Password, password);
        long result = db.insert(this.Table_Name, null, contentValues);
        return result;
    }
    public String selectData() {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {this.userID, this.fullName, this.userName, this.Password};
        Cursor result = db.query(this.Table_Name, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (result.moveToNext()) {
            int userid = result.getInt(0);
            String fullname = result.getString(1);
            String name = result.getString(2);
            String pass = result.getString(3);
            stringBuffer.append(userid+ "----> ID "+ " \n FullName: " + fullname +
                    " \n Name: " + name + " \n Password: " + pass + "\n");
        }
        return stringBuffer.toString();
    }

    public String searchtData(String fullname, String username) {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {this.userID, this.fullName, this.userName, this.Password};
        Cursor result = db.query(this.Table_Name, columns, this.fullName +" like '%"+
                fullname+"%' and "+ this.userName +" like '%"+ username+"%' ", null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (result.moveToNext()) {
            int userid = result.getInt(0);
            String fullusername = result.getString(1);
            String name = result.getString(2);
            String pass = result.getString(3);
            stringBuffer.append(userid+ "----> ID "+ " \n FullName: " + fullusername + " \n Name: " + name + " \n Password: " + pass + "\n");
        }
        return stringBuffer.toString();
    }
    public int updateData(String fullname, String username, String newfullname,
                          String newusername) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.fullName, newfullname);
        contentValues.put(this.userName, newusername);
        String[] arg = {fullname,username};
        int result = db.update(this.Table_Name,contentValues,this.fullName +" = ? and "+this.userName+" = ? " , arg);
        return result;
    }

    public int deleteData(String fullname, String username) {
        SQLiteDatabase db = getWritableDatabase();
        String[] arg = {fullname,username};
        int result = db.delete(this.Table_Name,this.fullName +" = ? and "+this.userName+" = ? " , arg);
        return result;
    }
}

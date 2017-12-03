package com.ghawadedilip.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dilip on 03-Dec-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME="Mydata.db";
  private static final int DATABASE_VERSION=1;

  private static final String KEY_NAME="NAME";
  private static final String KEY_EMAIL="EMAIL";
  private static final String KEY_MOBNO="MOBNO";
  private static final String KEY_PASSWORD="PASSWORD";
  private static final String KEY_ADDRESS="ADDRESS";
  private static final String KEY_CITY="CITY";
  private static final String TABLE_NAME="USER_REGISTER";
  protected static final String CREATE_QUERY=
    "CREATE TABLE " +TABLE_NAME+"" +
      "("+KEY_NAME+" TEXT,"+
          KEY_EMAIL+" TEXT,"+
          KEY_ADDRESS+" TEXT,"+
          KEY_CITY+" TEXT,"+
          KEY_MOBNO+" TEXT,"+
          KEY_PASSWORD+" TEXT);";


  public DatabaseHelper(Context context)
  {
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_QUERY);
    Log.d("result","Table Created Successfully");

  }

  public void registerUser(String name,String email,String
    mobno,String password,String city,String address,SQLiteDatabase db)
  {
    ContentValues values = new ContentValues();
    values.put(KEY_NAME,name);
    values.put(KEY_EMAIL,email);
    values.put(KEY_ADDRESS,address);
    values.put(KEY_PASSWORD,password);
    values.put(KEY_CITY,city);
    values.put(KEY_MOBNO,mobno);
    db.insert(TABLE_NAME,null,values);

  }

  public List<DataModel> getAllRegisterUser()
  {
    String colm[] = {KEY_NAME,
                     KEY_EMAIL,
                     KEY_PASSWORD,
                     KEY_MOBNO,
                      KEY_CITY,
                      KEY_ADDRESS};

    String order = KEY_NAME + " ASC";

    List<DataModel> userlist = new ArrayList<DataModel>();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor =db.query(TABLE_NAME ,
      colm,
      null,
      null,
      null,
      null,
      order
    );
    if (cursor.moveToFirst())
    {
      do {
        DataModel dataModel = new DataModel();
        dataModel.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        dataModel.setEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
        dataModel.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
        dataModel.setMobno(cursor.getString(cursor.getColumnIndex(KEY_MOBNO)));
        dataModel.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
        dataModel.setCity(cursor.getString(cursor.getColumnIndex(KEY_CITY)));

        userlist.add(dataModel);

      }
      while (cursor.moveToNext());

    }
    cursor.close();
    db.close();
    return userlist;
  }


  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

   /* sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
    onCreate(sqLiteDatabase);*/
  }
}

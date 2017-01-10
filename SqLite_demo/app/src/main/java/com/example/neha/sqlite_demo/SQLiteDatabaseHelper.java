package com.example.neha.sqlite_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by neha on 12/29/16.
 */

public class SQLiteDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "StudentDetails.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "StudentsInfo";
    private Context context;

    // Path of DB File: /data/data/your_package_name/databases/StudentDetails.db
    // This constructor is responsible to make DB file in Android.

    public SQLiteDatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion)
    {
        // Constructor
       super(context, DATABASE_NAME, factory, DATABASE_VERSION);
       // super(context,"StudentDetails.db",factory,1);
        this.context=context;

    }
    // onCreate method is responsible to create Tables inside the DB file
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

   String query="CREATE TABLE IF NOT EXIST "+ TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "number LONG," +
                "email TEXT," +
                "city TEXT)";

        sqLiteDatabase.execSQL(query);  // To create table

        Toast.makeText(context,"Table Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {

    }

    public boolean addStudentDetails(String name, String sNumber, String email, String city)
    {
        long number=Long.parseLong(sNumber);

        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("number",number);
        contentValues.put("email",email);
        contentValues.put("city",city);

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long x=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //long x=sqLiteDatabase.insert("StudentsInfo",null,contentValues);

        if(x>0)
            return true;
        else
            return false;
    }

    public ArrayList<String> getFirsNames()
    {
        ArrayList<String> arrayList= new ArrayList<>();

        String query="SELECT name FROM "+ TABLE_NAME;

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);

        if (cursor !=null)
        {
            cursor.moveToFirst();

            do
            {
               String name=cursor.getString(cursor.getColumnIndex("name"));
                arrayList.add(name);

            }while (cursor.moveToNext());

            cursor.close();
            return arrayList;
        }


        return null;
    }

    public StringBuilder getSingleContact(String name)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE name LIKE '" + name + "%'";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor != null)
        {
            cursor.moveToFirst();

            do
            {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                stringBuilder.append("ID: " + id).append("\n");

                String sName = cursor.getString(cursor.getColumnIndex("name"));
                stringBuilder.append("Name: " + sName).append("\n");

                int number = cursor.getInt(cursor.getColumnIndex("number"));
                stringBuilder.append("Number: " + number).append("\n");

                String email = cursor.getString(cursor.getColumnIndex("email"));
                stringBuilder.append("Email: " + email).append("\n");

                String city = cursor.getString(cursor.getColumnIndex("city"));
                stringBuilder.append("City: " + city).append("\n");

            }while (cursor.moveToNext());

            cursor.close();
            return stringBuilder;

        }

        return null;
    }

    }


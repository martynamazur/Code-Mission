package com.example.nauka;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static  final  String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_USER_EMAIL = "CUSTOMER_EMAIL";
    public static  final  String CUSTOMER_PASSWORD = "CUSTOMER_PASSWORD";
    public static final String COLUMN_PRIVACY_POLICY = "PRIVACY_POLICY";
    public static final String COLUMN_NEWSLETTER = "NEWSLETTER";
    public static  final  String COLUMN_ID = "ID";



    public DataBaseHelper(@Nullable Context context) {
        super(context,"users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // this is called the first time a database is accessed = create a new databse


        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER_EMAIL + " TEXT, " +
                CUSTOMER_PASSWORD + "TEXT, " +
                COLUMN_PRIVACY_POLICY + " BLOB," +
                COLUMN_NEWSLETTER+ "BLOB )";

        sqLiteDatabase.execSQL(createTableStatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // this is called if the databse version number changes. It prevents users appas from braking  when ypou change the databse design

    }}

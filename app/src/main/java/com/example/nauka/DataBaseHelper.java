package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.nauka.singup.SinUp_UserModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DataBaseHelper extends SQLiteOpenHelper {




    // USER
    public static final String USER_TABLE = "user_table";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";
    public static final String COLUMN_PRIVACY_POLICY = "privacy_policy";
    public static final String COLUMN_NEWSLETTER = "newsletter";
    public static final String COLUMN_ID = "id";

    // LAST ACTIVE
    public static final String LOGIN_HISTORY_TABLE = "login_history";
    public static final String COLUMN_ID_LA = "id_la";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_LOGIN_TIME = "login_time";

    // MY PROFILE
    public static final String USER_PROFILE_TABLE = "user_profile";
    public static final String COLUMN_USER_ID_UP = "user_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_LEVEL = "lv";
    public static final String COLUMN_EXPERIENCE_POINTS = "experience_points";
    public static final String COLUMN_TEAM_NAME = "team_name";
    public static final String COLUMN_FOLLOWING_COUNT = "following_count";
    public static final String COLUMN_FOLLOWERS_COUNT = "followers_count";
    public static final String COLUMN_ACCOUNT_CREATION_DATE = "account_creation_date";
    private static final String COLUMN_STREAK = "streak";






    public DataBaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // tu tworze tabelki

        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER_EMAIL + " TEXT, " +
                USER_PASSWORD + " TEXT, " +
                COLUMN_PRIVACY_POLICY + " INTEGER," +
                COLUMN_NEWSLETTER + " INTEGER )";

        sqLiteDatabase.execSQL(createTableStatement);


        String createTableStatement2 = "CREATE TABLE " + LOGIN_HISTORY_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER_ID + " INTEGER, " +
                COLUMN_LOGIN_TIME + " TEXT, " +
                "FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " + USER_TABLE + "(" + COLUMN_ID + ") ON DELETE CASCADE)";

        sqLiteDatabase.execSQL(createTableStatement2);

        String createUserProfileTable = "CREATE TABLE " + USER_PROFILE_TABLE + " (" +
                COLUMN_USER_ID_UP + " INTEGER PRIMARY KEY," +
                COLUMN_USERNAME + " TEXT," +
                COLUMN_LEVEL + " INTEGER," +
                COLUMN_EXPERIENCE_POINTS + " INTEGER," +
                COLUMN_TEAM_NAME + " TEXT," +
                COLUMN_FOLLOWING_COUNT + " INTEGER," +
                COLUMN_FOLLOWERS_COUNT + " INTEGER," +
                COLUMN_STREAK + " INTEGER," +
                COLUMN_ACCOUNT_CREATION_DATE + " TEXT," +
                "FOREIGN KEY (" + COLUMN_USER_ID_UP + ") REFERENCES " + USER_TABLE + "(" + COLUMN_ID + ")" +
                ")";
        sqLiteDatabase.execSQL(createUserProfileTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // this is called if the database version number changes. It prevents users' apps from breaking when you change the database design
    }

    public boolean addOne(SinUp_UserModel sinUp_userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_EMAIL, sinUp_userModel.getEmail_adress());
        cv.put(USER_PASSWORD, sinUp_userModel.getPassword());
        cv.put(COLUMN_NEWSLETTER, sinUp_userModel.getNewsletter().isChecked() ? 1 : 0);
        cv.put(COLUMN_PRIVACY_POLICY, sinUp_userModel.getPrivacyPolicy().isChecked() ? 1 : 0);


        long insert = db.insert(USER_TABLE, null, cv);
        return insert != -1;


    }

    public boolean isEmailExists(String email){
        SQLiteDatabase db = this.getReadableDatabase();

        /*
            Metoda zwraca liczbę wierszy spełniających warunki zapytania w tabeli bazy danych.
         */
        long count = DatabaseUtils.queryNumEntries(db, USER_TABLE, COLUMN_USER_EMAIL + "=?", new String[]{email});
        db.close();
        System.out.println("CO w isemailExists" + (count > 0));
        return count > 0;

    }

    // porownuje email i haslo w bazie danych
    public boolean singInValidation(String password, String email){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = { COLUMN_USER_EMAIL, USER_PASSWORD };
        String selection = COLUMN_USER_EMAIL + " = ? AND " + USER_PASSWORD + " = ?";
        String[] selectionArgs = { email, password };


        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return  exists;

    }

    @SuppressLint("Range")
    public int getIdByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_USER_EMAIL + "=?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        int id = -1;
        if (cursor.moveToFirst()) {
            id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
        }
        cursor.close();
        db.close();
        return id;
    }

    public boolean comparePasswordsById(String password, String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean isSame = false;
        String[] columns = {USER_PASSWORD};
        String selection = COLUMN_ID + "=?";
        String[] selectionArgs = {id};
        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String passwordTest = cursor.getString(cursor.getColumnIndex(USER_PASSWORD));
            if (Objects.equals(passwordTest, password)) {
                isSame = true;
            }
        }
        cursor.close();
        db.close();
        return isSame;
    }

    public boolean changeEmail(String id, String newEmail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_EMAIL, newEmail);
        int numRowsUpdated = db.update(USER_TABLE, values, COLUMN_ID + "=?", new String[]{id});
        db.close();
        return numRowsUpdated > 0;
    }

    public void updateAddStreak(){

    }

    public void updateDateStampLastActive(String userId){

        Date loginTime= new Date();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_USER_ID,userId);
        cv.put(COLUMN_LOGIN_TIME, String.valueOf(loginTime));
        db.insert(LOGIN_HISTORY_TABLE, null, cv);
        db.close();
    }

    public List<Message> loadMessagesFromDatabase() {
        List<Message> messages = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query("feed_messages_general", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            @SuppressLint("Range") String header = cursor.getString(cursor.getColumnIndex("title_message"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("message_content"));
            @SuppressLint("Range") long timestamp = cursor.getLong(cursor.getColumnIndex("post_date"));
            @SuppressLint("Range") int messageId = cursor.getInt(cursor.getColumnIndex("message_id"));

            Date date = new Date(timestamp);

            Message message = new Message();
            message.setHeader(header);
            message.setContent(content);
            message.setDate(date);
            message.setMessageId(messageId);

            messages.add(message);
        }

        cursor.close();


        return messages;
    }




}

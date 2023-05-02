package com.example.nauka;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "user_table";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";
    public static final String COLUMN_PRIVACY_POLICY = "privacy_policy";
    public static final String COLUMN_NEWSLETTER = "newsletter";
    public static final String COLUMN_ID = "id";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER_EMAIL + " TEXT, " +
                USER_PASSWORD + " TEXT, " +
                COLUMN_PRIVACY_POLICY + " INTEGER," +
                COLUMN_NEWSLETTER + " INTEGER )";

        sqLiteDatabase.execSQL(createTableStatement);

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

                        // nie musze robic łancucha bo tutaj mam odrazu
        Cursor cursor = db.query(USER_TABLE, null,
                COLUMN_USER_EMAIL + "=?", new String[]{email},
                null, null, null);

        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;

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

}

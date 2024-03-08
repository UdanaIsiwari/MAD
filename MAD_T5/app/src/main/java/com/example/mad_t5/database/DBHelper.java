package com.example.mad_t5.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                        UsersMaster.Users._ID+ "INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_USERNAME+ " TEXT," +
                        UsersMaster.Users.COLUMN_NAME_PASSWORD+ " TEXT)" ;

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    public long addInfo(String username , String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME,username);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);

        return db.insert(UsersMaster.Users.TABLE_NAME,null,values);
    }

    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String [] projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_USERNAME,
                UsersMaster.Users.COLUMN_NAME_PASSWORD
        };

        String sortOrder = UsersMaster.Users._ID + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List info = new ArrayList<>();

        while(cursor.moveToNext()){
            String username = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));

            info.add(username + ":" + password);
        }
        cursor.close();
        return info;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

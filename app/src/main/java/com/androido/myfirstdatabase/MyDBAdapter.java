package com.androido.myfirstdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 10/08/2017.
 */

public class MyDBAdapter {
    private static final String DATABASE_NAME = "data";
    private Context mContext;
    private MyDBHelper mDbHelper;
    private SQLiteDatabase mSqLiteDatabase;
    private int DATABASE_VERSION = 1;

    public MyDBAdapter(Context context) {

        this.mContext = context;
        mDbHelper = new MyDBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void open() {
        mSqLiteDatabase = mDbHelper.getWritableDatabase();
    }
}

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE students (id integer primary key autoincrement, name text, faculty integer);";
        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS students;";
        db.execSQL(query);
        onCreate(db);

    }
}

    public void insertStudents(String name, int faculty) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("faculty", faculty);
        mSqLiteDatabase.insert("students", null, cv);
    }

    public List<String> selectAllStudents() {
        List<String> allStudents = new ArrayList<>();
        Cursor cursor = mSqLiteDatabase.query("students", null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                allStudents.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        return allStudents;
    }

        public void deleteAllEngineers()
        {
            mSqLiteDatabase.delete("students",null,null );
        }



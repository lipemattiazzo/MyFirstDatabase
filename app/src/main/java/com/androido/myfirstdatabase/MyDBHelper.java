package com.androido.myfirstdatabase;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrador on 10/08/2017.
 */

class MyDBHelper {
    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }
}

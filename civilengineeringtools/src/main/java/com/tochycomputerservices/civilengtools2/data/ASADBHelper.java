package com.tochycomputerservices.civilengtools2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 *  Author: Eze-Odikwa Tochukwu Jed
 *  Last date modified: 11-12-2022
 *  (C), All rights reserved, Tochy computer services 2022
 *
 * */
public class ASADBHelper extends SQLiteOpenHelper {

    private final String LOG_TAG = getClass().getSimpleName();
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "asa.db";

    public ASADBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ASADATA_TABLE = "CREATE TABLE " + ASADBContract.ASADBEntry.TABLE_NAME + " (" +
                ASADBContract.ASADBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ASADBContract.ASADBEntry.COLUMN_ASADATA_TITLE + " TEXT NOT NULL, " +
                ASADBContract.ASADBEntry.COLUMN_ASADATA_DESC + " TEXT, " +
                ASADBContract.ASADBEntry.COLUMN_ASDADATA_JSONOBJECT + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_ASADATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

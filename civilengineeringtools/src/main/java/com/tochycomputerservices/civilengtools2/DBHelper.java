package com.tochycomputerservices.civilengtools2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Copyright 2022 Eze-Odikwa Tochukwu jed
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String database_Name="HISTORY.DB";
    private static final int database_Version=1;
    private static final String TAG="DATABASE OPERATIONS";
    private static final String table_Name="history";
    private static final String column1="calculator_name";
    private static final String column2="expression";
    private static final String create_Table="CREATE TABLE "+table_Name+"("+column1+" TEXT,"+column2+" TEXT);";

    SQLiteDatabase db;
    public DBHelper(ScientificCalculator context) {
        super(context,database_Name,null,database_Version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Table);

    }

    public void insert(String calcName,String expression)
    {
        db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(column1,calcName);
        contentValues.put(column2, expression);
        db.insert(table_Name, null, contentValues);
        db.close();
    }

    public ArrayList<String> showHistory(String calcName)
    {
        db=getReadableDatabase();
        Cursor cursor;
        ArrayList<String> list=new ArrayList<String>();
        String []selectionArgs={calcName};
        //cursor=db.query(table_Name,columns,column1+" LIKE ?",selectionArgs,null,null,null);
        cursor=db.rawQuery("select * from "+table_Name+" where "+column1+" = ?",selectionArgs);
        if(cursor.moveToFirst())
        {
            do
            {
                String expression=cursor.getString(1);
                list.add(expression);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

    public void deleteRecords(String calcName)
    {
        db=getWritableDatabase();
        String value[]={calcName};
        int i=db.delete(table_Name, column1+"=?", value);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
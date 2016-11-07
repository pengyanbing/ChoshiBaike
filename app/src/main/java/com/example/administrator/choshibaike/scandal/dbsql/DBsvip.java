package com.example.administrator.choshibaike.scandal.dbsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
public class DBsvip extends SQLiteOpenHelper {

    public static String DBNAME = "scard.db";
    public static String NAME = "svip";
    public static int DBVERSION = 1;
    public DBsvip(Context context) {
        super(context, DBNAME, null, DBVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREAT TABLE IF NOT EXISTS " + NAME + "(_id INTEGER PRIMARY KEY,USERNAME TEXT,PASSWORD TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

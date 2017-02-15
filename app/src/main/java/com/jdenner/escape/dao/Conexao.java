package com.jdenner.escape.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Juliano on 04/12/16.
 */
public class Conexao extends SQLiteOpenHelper {

    private static final String DB_NAME = "escape.db";
    private static final int DB_VERSION = 1;

    public Conexao(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "CREATE TABLE nivel (" +
                "  codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "  data TEXT NOT NULL," +
                "  numero INTEGER NOT NULL," +
                "  movimentos INTEGER NOT NULL" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.jdenner.escape.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Juliano on 04/12/16.
 */

public class NivelDao {

    public static void inserir(Context c, int numero, int movimentos) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ContentValues valores = new ContentValues();
        valores.put("data", sdf.format(new Date()));
        valores.put("numero", numero);
        valores.put("movimentos", movimentos);

        Conexao con = new Conexao(c);
        SQLiteDatabase db = con.getWritableDatabase();
        db.insert("nivel", null, valores);
        db.close();
        con.close();
    }

    public static int nivelAtual(Context c) throws ParseException {
        String colunas[] = {"numero"};
        Conexao con = new Conexao(c);
        SQLiteDatabase db = con.getReadableDatabase();
        Cursor cursor = db.query("nivel", colunas, null, null, null, null, null);

        int nivel = 0;
        while (cursor.moveToNext()) {
            if (cursor.getInt(0) > nivel) {
                nivel = cursor.getInt(0);
            }
        }
        return nivel;
    }
}

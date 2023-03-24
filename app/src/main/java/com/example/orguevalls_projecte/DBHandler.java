package com.example.orguevalls_projecte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context) {
        super(context, "db_orgue", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Al crear-se la BBDD, crea la taula incidencies
        db.execSQL("CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "encerts INTEGER NOT NULL," +
                "errors INTEGER NOT NULL," +
                "musica BOOLEAN NOT NULL" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private void crearUser(int punt) {
        SQLiteDatabase db = getWritableDatabase();
        crearUsers(db, punt);
    }

    private void crearUsers(SQLiteDatabase db, int punt) {
        ContentValues cv = new ContentValues();
        cv.put("encerts", punt);
        cv.put("errors", punt);
        cv.put("musica", true);
        db.insertOrThrow("user", null, cv);
        System.out.println("Usuari creat");
    }

    public void cargarDades() {
        if (!hasUser()) {
            crearUser(0);
        }
    }

    public boolean hasUser() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Genera consulta i la guarda en un cursor
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user", null);

        // Mou el curso a la primera posició
        if (cursorCourses.moveToFirst()) {
            do {
                System.out.println("Punt: " + cursorCourses.getInt(1));
                return true;
            } while (cursorCourses.moveToNext());
        } else {
            System.out.println("Tamo fuera: ");
            cursorCourses.close();
            return false;
        }
    }

    public int getEncerts() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Genera consulta i la guarda en un cursor
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user", null);

        // Mou el curso a la primera posició
        if (cursorCourses.moveToFirst()) {
            do {
                return cursorCourses.getInt(1);
            } while (cursorCourses.moveToNext());
        } else {
            cursorCourses.close();
            return 0;
        }
    }

    public int getErrors() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Genera consulta i la guarda en un cursor
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user", null);

        // Mou el curso a la primera posició
        if (cursorCourses.moveToFirst()) {
            do {
                return cursorCourses.getInt(2);
            } while (cursorCourses.moveToNext());
        } else {
            cursorCourses.close();
            return 0;
        }
    }

    public void afegirEncert() {
        SQLiteDatabase db = this.getWritableDatabase();

        int p = getEncerts() + 1;
        System.out.println("Punt: " + p);
        ContentValues values = new ContentValues();
        values.put("encerts", p);

        db.update("user", values, "id=1", null);
        db.close();
    }

    public void afegirError() {
        SQLiteDatabase db = this.getWritableDatabase();

        int p = getEncerts() + 1;
        System.out.println("Punt: " + p);
        ContentValues values = new ContentValues();
        values.put("errors", p);

        db.update("user", values, "id=1", null);
        db.close();
    }

    public void reestablishData() {
        SQLiteDatabase db = this.getWritableDatabase();

        // Genera consulta i la guarda en un cursor
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user", null);

        // Mou el curso a la primera posició
        if (cursorCourses.moveToFirst()) {
            do {
                ContentValues values = new ContentValues();
                values.put("encerts", 0);
                values.put("errors", 0);

                db.update("user", values, "id=1", null);
            } while (cursorCourses.moveToNext());
        }
    }

    public boolean isMusicaEnabled() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Genera consulta i la guarda en un cursor
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user", null);

        cursorCourses.moveToFirst();
        // Mou el curso a la primera posició
        do {
            System.out.println("Musica: " + cursorCourses.getInt(1));
            if (cursorCourses.getInt(3) == 1) {
                return true;
            } else {
                return false;
            }
        } while (cursorCourses.moveToNext());
    }

    public void enableMusica() {
        SQLiteDatabase db = this.getWritableDatabase();

        int p = 1;
        System.out.println("Musica: " + p);
        ContentValues values = new ContentValues();
        values.put("musica", p);

        db.update("user", values, "id=1", null);
        db.close();
    }

    public void disableMusica() {
        SQLiteDatabase db = this.getWritableDatabase();

        int p = 0;
        System.out.println("Musica: " + p);
        ContentValues values = new ContentValues();
        values.put("musica", p);

        db.update("user", values, "id=1", null);
        db.close();
    }
}

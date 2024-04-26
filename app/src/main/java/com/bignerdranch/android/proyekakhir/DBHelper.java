package com.bignerdranch.android.proyekakhir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Digitalent.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String TABLE_MAHASISWA = "mahasiswa";
    public static final String COLUMN_ID_MAHASISWA = "id_mahasiswa";
    private static final String COLUMN_NOMOR = "nomor";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_TANGGAL = "tanggal_lahir";
    private static final String COLUMN_KELAMIN = "jenis_kelamin";
    private static final String COLUMN_ALAMAT = "alamat";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableQuery = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createUserTableQuery);

        String createNotesTableQuery = "CREATE TABLE " + TABLE_MAHASISWA + " (" +
                COLUMN_NOMOR + " INTEGER PRIMARY KEY, " +
                COLUMN_NAMA + " TEXT, " +
                COLUMN_TANGGAL + " TEXT, " +
                COLUMN_KELAMIN + " TEXT, " +
                COLUMN_ALAMAT + " TEXT)";
        db.execSQL(createNotesTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public boolean insertData(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close(); // Close the database connection
        return result != -1; // Return true if inserted successfully, false otherwise
    }

    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase(); // Use readable database
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_EMAIL + " = ?", new String[]{email});
        boolean exists = cursor.getCount() > 0;
        cursor.close(); // Close the cursor
        db.close(); // Close the database connection
        return exists;
    }

    public boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase(); // Use readable database
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?", new String[]{email, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close(); // Close the cursor
        db.close(); // Close the database connection
        return exists;
    }

    public boolean insertDataMahasiswa(String nama, String tanggalLahir, String jenisKelamin, String alamat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("tanggal_lahir", tanggalLahir);
        values.put("jenis_kelamin", jenisKelamin);
        values.put("alamat", alamat);
        long result = db.insert(TABLE_MAHASISWA, null, values);
        db.close();
        return result != -1; // Returns true if insertion is successful
    }

    public boolean updateDataMahasiswa(String nomor, String nama, String tanggalLahir, String jenisKelamin, String alamat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("tanggal_lahir", tanggalLahir);
        values.put("jenis_kelamin", jenisKelamin);
        values.put("alamat", alamat);

        int result = db.update("MAHASISWA", values, "nomor = ?", new String[]{nomor});
        db.close();
        return result > 0; // Returns true if at least one row was updated
    }

//    private void updateMahasiswa(String nomor, String nama, String tanggalLahir, String jenisKelamin, String alamat) {
//        boolean success = dbHelper.updateDataMahasiswa(nomor, nama, tanggalLahir, jenisKelamin, alamat);
//        if (success) {
//            Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
//        }
//    }

    public Cursor getAllMAHASISWA() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM MAHASISWA", null);
    }

}
//
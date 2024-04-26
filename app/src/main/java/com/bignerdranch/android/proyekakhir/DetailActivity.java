package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    private Button btnEdit; // Added this line

    private EditText nomorDetail, namaDetail, tanggalDetail, jenisDetail, alamatDetail;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi EditText
        nomorDetail = findViewById(R.id.nomor_detail);
        namaDetail = findViewById(R.id.nama_detail);
        tanggalDetail = findViewById(R.id.tanggal_detail);
        jenisDetail = findViewById(R.id.jenis_detail);
        alamatDetail = findViewById(R.id.alamat_detail);

        // Inisialisasi Button Edit
        btnEdit = findViewById(R.id.btn_edit); // Added this line

        // Inisialisasi DBHelper
        dbHelper = new DBHelper(this);

        // Mendapatkan data mahasiswa dari database
        Cursor cursor = dbHelper.getAllMAHASISWA();

        // Pindah ke baris pertama hasil query
        if (cursor.moveToFirst()) {
            // Mendapatkan data dari cursor
            String nomor = cursor.getString(cursor.getColumnIndex("nomor"));
            String nama = cursor.getString(cursor.getColumnIndex("nama"));
            String tanggalLahir = cursor.getString(cursor.getColumnIndex("tanggal_lahir"));
            String jenisKelamin = cursor.getString(cursor.getColumnIndex("jenis_kelamin"));
            String alamat = cursor.getString(cursor.getColumnIndex("alamat"));

            // Menampilkan data ke EditText
            nomorDetail.setText(nomor);
            namaDetail.setText(nama);
            tanggalDetail.setText(tanggalLahir);
            jenisDetail.setText(jenisKelamin);
            alamatDetail.setText(alamat);
        }

        // Tutup cursor dan database
        cursor.close();
        dbHelper.close();

        // Set OnClickListener untuk Button Edit
        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, EditActivity.class);
            startActivity(intent);
        });
    }
}}
package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText namaDetail, tanggalDetail, jenisDetail, alamatDetail;
    private Button btnEdit;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        namaDetail = findViewById(R.id.nama_detail);
        tanggalDetail = findViewById(R.id.tanggal_detail);
        jenisDetail = findViewById(R.id.jenis_detail);
        alamatDetail = findViewById(R.id.alamat_detail);
        btnEdit = findViewById(R.id.btn_edit);

        dbHelper = new DBHelper(this);

        // Mendapatkan data yang akan diedit dari Intent
        String nomor = getIntent().getStringExtra("nomor");
        String nama = getIntent().getStringExtra("nama");
        String tanggalLahir = getIntent().getStringExtra("tanggal_lahir");
        String jenisKelamin = getIntent().getStringExtra("jenis_kelamin");
        String alamat = getIntent().getStringExtra("alamat");

        // Menampilkan data ke EditText
        namaDetail.setText(nama);
        tanggalDetail.setText(tanggalLahir);
        jenisDetail.setText(jenisKelamin);
        alamatDetail.setText(alamat);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan data dari EditText
                String editedNama = namaDetail.getText().toString();
                String editedTanggalLahir = tanggalDetail.getText().toString();
                String editedJenisKelamin = jenisDetail.getText().toString();
                String editedAlamat = alamatDetail.getText().toString();

                // Memperbarui data di database
                boolean isSuccess = dbHelper.updateDataMahasiswa(nomor, editedNama, editedTanggalLahir, editedJenisKelamin, editedAlamat);

                if (isSuccess) {
                    Toast.makeText(EditActivity.this, "Data berhasil diperbarui", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditActivity.this, "Gagal memperbarui data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
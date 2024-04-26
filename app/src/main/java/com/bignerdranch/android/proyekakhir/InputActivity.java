package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InputActivity extends AppCompatActivity {

    DBHelper dbHelper;

    private EditText etNamaDetail, etTanggalDetail, etJenisDetail, etAlamatDetail;

    Button btnSave;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dbHelper = new DBHelper(this);

        etNamaDetail = findViewById(R.id.et_namaDetail);
        etTanggalDetail = findViewById(R.id.et_tanggalDetail);
        etJenisDetail = findViewById(R.id.et_jenisDetail);
        etAlamatDetail = findViewById(R.id.et_alamatDetail);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v -> {
            if (etNamaDetail.getText().toString().isEmpty()) {
                Toast.makeText(InputActivity.this, "Error: Nama harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (etTanggalDetail.getText().toString().isEmpty()) {
                Toast.makeText(InputActivity.this, "Error: Lokasi harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (etJenisDetail.getText().toString().isEmpty()) {
                Toast.makeText(InputActivity.this, "Error: Harga Tiket harus diisi!", Toast.LENGTH_SHORT).show();
            }else if (etAlamatDetail.getText().toString().isEmpty()) {
                Toast.makeText(InputActivity.this, "Error: Deskripsi harus diisi!", Toast.LENGTH_SHORT).show();
            }else {
                dbHelper.insertDataMahasiswa(etNamaDetail.getText().toString(), etTanggalDetail.getText().toString(), etJenisDetail.getText().toString(), etAlamatDetail.getText().toString());
                etNamaDetail.setText("");
                etTanggalDetail.setText("");
                etJenisDetail.setText("");
                etAlamatDetail.setText("");
                Toast.makeText(InputActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
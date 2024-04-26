package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bignerdranch.android.proyekakhir.databinding.ActivityDataMahasiswaBinding;
import com.bignerdranch.android.proyekakhir.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnInput, btnInformasi, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.lihat_button);
        btnInput = (Button) findViewById(R.id.input_button);
        btnInformasi = (Button) findViewById(R.id.info_button);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        btnInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputActivity.class);
            startActivity(intent);
        });

        btnInformasi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InformasiActivity.class);
            startActivity(intent);
        });
    }
}
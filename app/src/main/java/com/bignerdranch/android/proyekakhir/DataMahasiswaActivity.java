
package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class DataMahasiswaActivity extends AppCompatActivity {

    private ListView lvitem;
    private String[] datamahasiswa = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        lvitem = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datamahasiswa);
        lvitem.setAdapter(adapter);
    }
}

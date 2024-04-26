package com.bignerdranch.android.proyekakhir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnProses = (Button) findViewById(R.id.lihat_button); //

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("Choose options");

                String[] options = {"Lihat Data", "Update Data", "Hapus Data"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Toast.makeText(DialogActivity.this, "View Data Selected", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(DialogActivity.this, "Update Data Selected", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(DialogActivity.this, "Delete Data Selected", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
//                builder.show();
            }
        });
    }
}

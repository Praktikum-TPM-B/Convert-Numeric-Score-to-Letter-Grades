package com.praktpm.formmahasiswa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TextView txtNama  = (TextView) findViewById(R.id.nama);
        TextView txtNim   = (TextView) findViewById(R.id.nim);
        TextView txtHasil = (TextView) findViewById(R.id.nilai);

        Bundle extras = getIntent().getExtras();

        String NAMA = "NAMA";
        String nama = extras.getString(NAMA);
        txtNama.setText(String.format(": %s", nama));

        String NIM = "NIM";
        String nim = extras.getString(NIM);
        txtNim.setText(String.format(": %s", nim));

        String HASIL = "HASIL";
        String hasil = extras.getString(HASIL);
        txtHasil.setText(String.format(": %s", hasil));
    }
}

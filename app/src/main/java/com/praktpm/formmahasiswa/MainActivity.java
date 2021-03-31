package com.praktpm.formmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String NAMA = "NAMA";
    private final String NIM = "NIM";
    private final String HASIL = "HASIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = findViewById(R.id.btn_submit);
        EditText etNama = findViewById(R.id.et_name);
        EditText etNIM = findViewById(R.id.et_nim);
        EditText etSkor = findViewById(R.id.et_skor);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nama    = etNama.getText().toString();
                    String nim     = etNIM.getText().toString();
                    String skor    = etSkor.getText().toString();
                    Intent i = new Intent(MainActivity.this, HasilActivity.class);
                    i.putExtra(NAMA, nama);
                    i.putExtra(NIM, nim);
                    double hasil   = Double.parseDouble(skor);

                    if(hasil <= 4.00){
                        if(hasil > 3.66 && hasil <= 4.00){
                            i.putExtra(HASIL, "A");
                        }else if(hasil > 3.33 && hasil <= 3.66) {
                            i.putExtra(HASIL, "A-");
                        }else if(hasil > 3.00 && hasil <= 3.33) {
                            i.putExtra(HASIL, "B+");
                        }else if(hasil > 2.66 && hasil <= 3.00) {
                            i.putExtra(HASIL, "B");
                        }else if(hasil > 2.33 && hasil <= 2.66) {
                            i.putExtra(HASIL, "B-");
                        }else if(hasil > 2.00 && hasil <= 2.33) {
                            i.putExtra(HASIL, "C+");
                        }else if(hasil > 1.66 && hasil <= 2.00) {
                            i.putExtra(HASIL, "C");
                        }else if(hasil > 1.33 && hasil <= 1.66) {
                            i.putExtra(HASIL, "C-");
                        }else if(hasil > 1.00 && hasil <= 1.33) {
                            i.putExtra(HASIL, "D+");
                        }else {
                            i.putExtra(HASIL, "D");
                        }
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplication(), "Interval skor tidak boleh di atas 4.00!", Toast.LENGTH_SHORT).show();
                    }


                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "Field tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
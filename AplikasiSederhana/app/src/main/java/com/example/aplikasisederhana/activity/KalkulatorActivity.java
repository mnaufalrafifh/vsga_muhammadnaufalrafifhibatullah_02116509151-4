package com.example.aplikasisederhana.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aplikasisederhana.R;

public class KalkulatorActivity extends AppCompatActivity {

    private EditText edtAngka1, edtAngka2;
    private Button btn_Tambah, btn_Kurang, btn_Kali, btn_Bagi, btn_Bersih;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        edtAngka1 = findViewById(R.id.edt_angka1);
        edtAngka2 = findViewById(R.id.edt_angka2);
        txtHasil = findViewById(R.id.txt_hasil);
        btn_Bersih = findViewById(R.id.btn_bersihkan);

        setTitle("Kalkulator");
    }

    public void bersihkan(View view) {
        edtAngka1.setText("");
        edtAngka2.setText("");
        txtHasil.setText("0.0");
    }

    public void tambah(View view) {
        double angka1 = Double.parseDouble(edtAngka1.getText().toString());
        double angka2 = Double.parseDouble(edtAngka2.getText().toString());
        double hasil = angka1 + angka2;
        txtHasil.setText(String.valueOf(hasil));
    }

    public void kurang(View view) {
        double angka1 = Double.parseDouble(edtAngka1.getText().toString());
        double angka2 = Double.parseDouble(edtAngka2.getText().toString());
        double hasil = angka1 - angka2;
        txtHasil.setText(String.valueOf(hasil));
    }

    public void bagi(View view) {
        double angka1 = Double.parseDouble(edtAngka1.getText().toString());
        double angka2 = Double.parseDouble(edtAngka2.getText().toString());
        double hasil = angka1 / angka2;
        txtHasil.setText(String.valueOf(hasil));
    }

    public void kali(View view) {
        double angka1 = Double.parseDouble(edtAngka1.getText().toString());
        double angka2 = Double.parseDouble(edtAngka2.getText().toString());
        double hasil = angka1 * angka2;
        txtHasil.setText(String.valueOf(hasil));
    }
}
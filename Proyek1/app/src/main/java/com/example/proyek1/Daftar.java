package com.example.proyek1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Daftar extends AppCompatActivity {

    Toolbar toolbar;
    EditText editUsername, editPassword, editEmail, editNamaLengkap, editAsalSekolah, editAlamat;
    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        toolbar = findViewById(R.id.toolbar_user);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Daftar");

        editUsername = findViewById(R.id.edt_username);
        editPassword = findViewById(R.id.edt_password);
        editEmail = findViewById(R.id.edt_email);
        editNamaLengkap = findViewById(R.id.edt_namalengkap);
        editAlamat = findViewById(R.id.edt_alamat);
        editAsalSekolah = findViewById(R.id.edt_asalsekolah);
        btn_simpan = findViewById(R.id.btnSimpan2);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidation()){
                    simpanFileData();
                }else {
                    Toast.makeText(Daftar.this, "Mohon Lengkapi Seluruh Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean isValidation(){
        if (editUsername.getText().toString().equals("") ||
        editPassword.getText().toString().equals("") ||
        editEmail.getText().toString().equals("") ||
        editNamaLengkap.getText().toString().equals("") ||
        editAsalSekolah.getText().toString().equals("") ||
        editAlamat.getText().toString().equals("")){
            return false;
        }else {
            return true;
        }
    }
    void simpanFileData(){
        String isiFile = editUsername.getText().toString() + ";" +
                editPassword.getText().toString() + ";" +
                editEmail.getText().toString() + ";" +
                editNamaLengkap.getText().toString() + ";" +
                editAsalSekolah.getText().toString() + ";" +
                editAlamat.getText().toString();
        File file = new File(getFilesDir(),
                editUsername.getText().toString());
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}
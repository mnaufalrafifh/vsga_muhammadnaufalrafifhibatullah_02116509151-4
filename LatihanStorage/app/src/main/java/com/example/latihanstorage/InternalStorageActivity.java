package com.example.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class InternalStorageActivity extends AppCompatActivity {

    private String keyInternal = "KEY_INTERNAL_STORAGE";
    private String FILE_NAME = "name_file.txt";
    private TextView txtIsiFile;
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        txtIsiFile = findViewById(R.id.txt_isi_file);
        edtText = findViewById(R.id.edt_text);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String newTitle = extras.getString(keyInternal);
            setTitle(newTitle);
        }

    }

    public void actionHapusFile(View view) {
        File file = new File(getFilesDir(), FILE_NAME);
        if (file.exists()){
            file.delete();
        }
    }

    public void actionBacaFile(View view) {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILE_NAME);

        if (file.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            }catch (Exception e){
                System.out.println("Error " + e.getMessage());
            }
            txtIsiFile.setText(text.toString());
        }
    }

    public void actionUbahFile(View view) {
        //String ubah = "Update Isi Data File Text";
        String ubah = edtText.getText().toString();

        if (!ubah.isEmpty()){
            File file = new File(getFilesDir(), FILE_NAME);
            FileOutputStream outputStream = null;
            try {
                file.createNewFile();
                outputStream = new FileOutputStream(file, true);
                outputStream.write(ubah.getBytes());
                outputStream.flush();
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "Input Text Kosong!", Toast.LENGTH_SHORT).show();
        }
    }

    public void actionBuatFile(View view) {
        String isiFile = "Membuat file baru";
        File file = new File(getFilesDir(), FILE_NAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
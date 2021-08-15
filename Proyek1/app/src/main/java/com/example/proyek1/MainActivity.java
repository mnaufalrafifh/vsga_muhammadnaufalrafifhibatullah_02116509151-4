package com.example.proyek1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

    }

    public void actionCatatan(View view) {
        Intent intent = new Intent(this, CatatanHarian.class);
        startActivity(intent);
    }

    public void actionLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
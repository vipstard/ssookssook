package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DiaryActivity2 extends AppCompatActivity {
    TextView dia_title;
    ImageView dia_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        Intent intent = getIntent();
        int img = intent.getIntExtra("img",0);
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");

        dia_title = findViewById(R.id.diary_title);
        dia_title.setText(title);
        dia_img = findViewById(R.id.diary_picture);
        dia_img.setImageResource(img);

    }
}
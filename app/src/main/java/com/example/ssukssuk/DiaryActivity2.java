package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DiaryActivity2 extends AppCompatActivity {
    TextView dia_title;
    TextView dia_content;
    Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        btn_reg = findViewById(R.id.diary_re);
        String title = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_title", null);
        String writer =DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_writer", null);
        String date = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_date", null);
        String content = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_content", null);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryActivity2.this,diary_select_edit.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();


        Toast.makeText(DiaryActivity2.this,date,Toast.LENGTH_SHORT).show();
        dia_title = findViewById(R.id.diary_title);
        dia_title.setText(title);
        dia_img = findViewById(R.id.diary_picture);
        dia_img.setImageResource(img);

    }
}
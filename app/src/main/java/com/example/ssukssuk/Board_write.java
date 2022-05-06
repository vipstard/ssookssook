package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Board_write extends AppCompatActivity {
    Button btn_rp;
    TextView tv_title,tv_content,tv_writer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        btn_rp = findViewById(R.id.btn_board_rp);
        tv_title = findViewById(R.id.board_title2);
        tv_content = findViewById(R.id.board_content2);
        tv_writer = findViewById(R.id.board_wirte2);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv_title.setText(title);
    }
}
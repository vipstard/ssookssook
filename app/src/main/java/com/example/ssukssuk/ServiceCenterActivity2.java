package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ServiceCenterActivity2 extends AppCompatActivity {

    TextView sc_text,sc_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_center2);

        sc_title = findViewById(R.id.sc_title);
        sc_text = findViewById(R.id.sc_text);

        Intent intent = getIntent();
        String title = intent.getStringExtra("SCtitle");
        String date = intent.getStringExtra("SCdate");

        sc_title.setText(title);
        // sc_text.setText();

    }
}
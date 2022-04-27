package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class newLogin_selecter extends AppCompatActivity {
    ImageButton basic, kakao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_selecter);
        basic = findViewById(R.id.imageButton);
        kakao = findViewById(R.id.imageButton2);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newLogin_selecter.this,new_Login_basic.class);
                startActivity(intent);
            }
        });
    }
}
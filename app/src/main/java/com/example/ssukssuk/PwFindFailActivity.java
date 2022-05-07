package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PwFindFailActivity extends AppCompatActivity {

    Button btnLogin, btnJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_find_fail);

        btnJoin = findViewById(R.id.btn_PFFA_Join);
        btnLogin = findViewById(R.id.btn_PFFA_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PwFindFailActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        //회원가입 버튼(회원가입 찾기 페이지 이동기능)
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PwFindFailActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
    }
}
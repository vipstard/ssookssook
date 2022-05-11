package com.example.ssukssuk.Find.Pw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.SignActivity;

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
                Intent intent = new Intent(PwFindFailActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IdFindFailActivity extends AppCompatActivity {

    Button btnLogin, btnJoin;
    TextView tvhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find_fail);

        btnJoin = findViewById(R.id.btn_IFFA_Join);
        btnLogin = findViewById(R.id.btn_IFFA_Login);
        tvhead = findViewById(R.id.tv_IFFA_Find);

        //getIntent로 값을 받아오는 intent 변수 생성??
//        Intent intent = getIntent();
        //불러온걸 받아온 값+??
//        String head = intent.getStringExtra("head")+"찾기";
        //tvName에 name 변수의 내용으로 출력
//        tvhead.setText(head);


        //로그인버튼(로그인 페이지 이동 기능)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IdFindFailActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        //회원가입 버튼(회원가입 찾기 페이지 이동기능)
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdFindFailActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }
}
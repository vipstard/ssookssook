package com.example.ssukssuk.Find.Pw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.R;

public class PwFindSuccessActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvName, tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_find_success);

        btnLogin = findViewById(R.id.btn_PFSA_Login);
        tvName = findViewById(R.id.tv_PFSA_Name);
        tvId = findViewById(R.id.tv_PFSA_Id);

        //getIntent로 값을 받아오는 intent 변수 생성??
        Intent intent = getIntent();
        //불러온걸 받아온 값+??
        String name = intent.getStringExtra("data")+" 님의 아이디는";
        //tvName에 name 변수의 내용으로 출력
        tvName.setText(name);

        //숫자 값 출력
//        int num = intent.getIntExtra("num",0);
//        tvId.setText(String.valueOf(num));


        //로그인버튼(로그인 페이지 이동 기능)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PwFindSuccessActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });



    }
}
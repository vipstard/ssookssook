package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IdFindSuccessActivity extends AppCompatActivity{

    Button btnLogin, btnPw;
    TextView tvName, tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find_success);

        btnLogin = findViewById(R.id.btn_IFSA_Login);
        btnPw = findViewById(R.id.btn_IFSA_Pw);
        tvName = findViewById(R.id.tv_IFSA_Name);
        tvId = findViewById(R.id.tv_IFSA_Id);

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
                Intent intent = new Intent(IdFindSuccessActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });


        //비밀번호찾기버튼(비밀번호 찾기 페이지 이동기능)
        btnPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdFindSuccessActivity.this, SignActivity.class);
                startActivity(intent);
            }

        });



    }
    //핸드폰 뒤로가기 버튼 막기
//    @Override
//    public void onBackPressed() {
//        //super.onBackPressed();
//    }

}
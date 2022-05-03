package com.example.ssukssuk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login, basic,idfind,pwfind;
    EditText user_id, user_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_id = findViewById(R.id.user_id);
        user_pw = findViewById(R.id.user_pw);
        login = findViewById(R.id.btn_login);
        basic = findViewById(R.id.btn_basic);
        idfind = findViewById(R.id.btn_idfind);
        pwfind = findViewById(R.id.btn_pwfind);

        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

        String id = user_id.getText().toString();
        String pw = user_pw.getText().toString();
        idfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, idfindActivity.class);
                startActivity(intent);
            }
        });
        pwfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,pwfindActivity.class);
                startActivity(intent);
            }
        });
        if(id!=null && pw != null) {
            if(user_id.equals("sc") && user_pw.equals("sc")) {
                Toast.makeText(LoginActivity.this, user_id +"님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        else if(id == null && pw == null) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (id.equals("sc") && pw.equals("sc")) {
                        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

                        SharedPreferences.Editor autoLogin = auto.edit();
                        autoLogin.putString("user_id", id);
                        autoLogin.putString("user_pw", pw);
                        //꼭 commit()을 해줘야 값이 저장됩니다 ㅎㅎ
                        autoLogin.commit();
                        Toast.makeText(LoginActivity.this, user_id.getText().toString() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "로그인 실패",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });







    }
    void showDialog() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(LoginActivity.this)
                .setTitle("회원가입페이지 이동")
                .setMessage("회원가입을 하시겠습니까?")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(LoginActivity.this, newLogin_selecter.class);

                        Toast.makeText(LoginActivity.this, "회원가입 페이지로 이동", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }) .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(LoginActivity.this, "회원 가입 ㄴㄴ", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }


}
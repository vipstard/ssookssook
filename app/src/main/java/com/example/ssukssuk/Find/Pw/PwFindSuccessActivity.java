package com.example.ssukssuk.Find.Pw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PwFindSuccessActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvName, tvPw;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("sign");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_find_success);

        btnLogin = findViewById(R.id.btn_PFSA_Login);
        tvName = findViewById(R.id.tv_PFSA_Name);
        tvPw = findViewById(R.id.tv_PFSA_Pw);

        String pw = PwFindSuccessActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("find_pw", null);
        String name = PwFindSuccessActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("find_name", null);

        tvName.setText(name+" 님의 비밀번호는");
        tvPw.setText(pw);

        SharedPreferences spf = PwFindSuccessActivity.this.
                getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        spf.edit().remove("find_name").commit();
        spf.edit().remove("find_pw").commit();






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
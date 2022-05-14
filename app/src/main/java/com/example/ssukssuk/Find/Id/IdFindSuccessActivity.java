package com.example.ssukssuk.Find.Id;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssukssuk.Find.Pw.PwFindActivity;
import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.VO.SignVO;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IdFindSuccessActivity extends AppCompatActivity {

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



        String id = IdFindSuccessActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("find_id", null);
        String name = IdFindSuccessActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("find_name", null);

        tvName.setText(name+" 님의 아이디는");
        tvId.setText(id);

        SharedPreferences spf = IdFindSuccessActivity.this.
                getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        spf.edit().remove("find_id").commit();
        spf.edit().remove("find_name").commit();






        //로그인버튼(로그인 페이지 이동 기능)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IdFindSuccessActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });


        //비밀번호찾기버튼(비밀번호 찾기 페이지 이동기능)
        btnPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdFindSuccessActivity.this, PwFindActivity.class);
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
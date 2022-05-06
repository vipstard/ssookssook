package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IdFindSuccessActivity extends AppCompatActivity{

    Button btnLogin, btnPw;
    TextView tvName, tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find_success);

        btnLogin = findViewById(R.id.btnLogin);
        btnPw = findViewById(R.id.btnPw);
        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdFindSuccessActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdFindSuccessActivity.this,LoginActivity.class);
                startActivity(intent);
            }

        });


    }

}
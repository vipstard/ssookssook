package com.example.ssukssuk.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;

public class EditActivity extends AppCompatActivity {

    Button btnBack, btnEdit;
    EditText edtName, edtPhone, edtEmail, edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnBack = findViewById(R.id.btn_EA_Back);
        btnEdit = findViewById(R.id.btn_EA_Edit);
        edtName = findViewById(R.id.edt_EA_Name);
        edtPhone = findViewById(R.id.edt_EA_Phone);
        edtEmail = findViewById(R.id.edt_EA_Email);
        edtAddress = findViewById(R.id.edt_EA_Address);

        //getIntent로 값을 받아오는 intent 변수 생성??
        Intent intent = getIntent();
        //불러온걸 받아온 값+??
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String address = intent.getStringExtra("address");

        //tvName에 name 변수의 내용으로 출력
        edtName.setText(name);
        edtPhone.setText(phone);
        edtEmail.setText(email);
        edtAddress.setText(address);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}
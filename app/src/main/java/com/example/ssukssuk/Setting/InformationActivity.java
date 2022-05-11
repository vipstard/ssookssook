package com.example.ssukssuk.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssukssuk.Fragment5;
import com.example.ssukssuk.R;

public class InformationActivity extends AppCompatActivity {

    Button btnBack, btnEdit;
    TextView tvName, tvPhone, tvEmail, tvAddress;
    Fragment5 frag_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        btnBack = findViewById(R.id.btn_IA_Back);
        btnEdit = findViewById(R.id.btn_IA_Edit);
        tvName = findViewById(R.id.tv_IA_Name);
        tvPhone = findViewById(R.id.tv_IA_Phone);
        tvEmail = findViewById(R.id.tv_IA_Email);
        tvAddress = findViewById(R.id.tv_IA_Address);
        frag_set = new Fragment5();



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tvName.getText().toString();
                String phone = tvPhone.getText().toString();
                String email = tvEmail.getText().toString();
                String address = tvAddress.getText().toString();

                Intent intent = new Intent(InformationActivity.this,EditActivity.class);

                intent.putExtra("name",name);
                intent.putExtra("phone",phone);
                intent.putExtra("email",email);
                intent.putExtra("address",address);

                startActivity(intent);
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
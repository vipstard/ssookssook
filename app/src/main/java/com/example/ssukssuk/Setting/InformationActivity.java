package com.example.ssukssuk.Setting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssukssuk.Fragment5;
import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.VO.SignVO;
import com.example.ssukssuk.VO.loginVO;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InformationActivity extends AppCompatActivity {

    Button btnBack, btnEdit;
    TextView tvName, tvPhone, tvEmail, tvAddress;
    Fragment5 frag_set;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("sign");

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

        String loginId = InformationActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                SignVO vo = snapshot.getValue(SignVO.class);


                if(loginId.equals(vo.getId())){
                    tvName.setText(vo.getName());
                    tvPhone.setText(vo.getPhone());
                    tvEmail.setText(vo.getEmail());
                    tvAddress.setText(vo.getAddress());

                }

                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(InformationActivity.this,EditActivity.class));
                    }
                });


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = tvName.getText().toString();
//                String phone = tvPhone.getText().toString();
//                String email = tvEmail.getText().toString();
//                String address = tvAddress.getText().toString();
//
//                Intent intent = new Intent(InformationActivity.this,EditActivity.class);
//
//                intent.putExtra("name",name);
//                intent.putExtra("phone",phone);
//                intent.putExtra("email",email);
//                intent.putExtra("address",address);
//
//                startActivity(intent);
//            }
//        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
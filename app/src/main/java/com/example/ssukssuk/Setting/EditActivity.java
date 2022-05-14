package com.example.ssukssuk.Setting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.VO.SignVO;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity {

    Button btnBack, btnEdit;
    EditText edtName, edtPhone, edtEmail, edtAddress;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("sign");

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

        String loginId = EditActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);

//        //getIntent로 값을 받아오는 intent 변수 생성??
//        Intent intent = getIntent();
//        //불러온걸 받아온 값+??
//        String name = intent.getStringExtra("name");
//        String phone = intent.getStringExtra("phone");
//        String email = intent.getStringExtra("email");
//        String address = intent.getStringExtra("address");
//
//        //tvName에 name 변수의 내용으로 출력
//        edtName.setText(name);
//        edtPhone.setText(phone);
//        edtEmail.setText(email);
//        edtAddress.setText(address);
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                SignVO vo = snapshot.getValue(SignVO.class);


                if (loginId.equals(vo.getId())) {
                    edtName.setText(vo.getName());
                    edtPhone.setText(vo.getPhone());
                    edtEmail.setText(vo.getEmail());
                    edtAddress.setText(vo.getAddress());


                    btnEdit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String key = snapshot.getKey();
                            //myRef2란 변수에 키값이 a인 값을 저장해준다
                            DatabaseReference myRef2 = myRef.child(key);
                            //수정하는 글의 값을 저장
                            String name = edtName.getText().toString();
                            String phone = edtPhone.getText().toString();
                            String email = edtEmail.getText().toString();
                            String address = edtAddress.getText().toString();


                            //데베 데이터 값을 변경하는 코드
                            Map<String, Object> updateMap = new HashMap<>();
                            updateMap.put("name", name);
                            updateMap.put("phone", phone);
                            updateMap.put("email", email);
                            updateMap.put("address", address);
                            myRef2.updateChildren(updateMap);

                            startActivity(new Intent(EditActivity.this, MainActivity.class));
                        }
                    });
                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String
                    previousChildName) {


            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String
                    previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
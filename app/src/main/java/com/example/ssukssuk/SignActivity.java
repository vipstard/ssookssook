package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssukssuk.VO.SignVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SignActivity extends AppCompatActivity {
    EditText edt_Name,edt_Id,edt_Pw,edt_Repw,edt_Phone,edt_Email,edt_Address;
//    Spinner year,month,day;
//    int month_sel;
    Button btn_Id_Check,btn_Back,btn_Signup;

    ArrayList<SignVO> list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);


        edt_Name = findViewById(R.id.edt_SA_Name);
        edt_Id = findViewById(R.id.btn_SA_Id);
        edt_Pw = findViewById(R.id.edt_SA_Pw);
        edt_Repw = findViewById(R.id.edt_SA_Repw);
        edt_Email = findViewById(R.id.edt_SA_Email);
        edt_Address = findViewById(R.id.edt_SA_Address);
        edt_Phone = findViewById(R.id.edt_SA_Phone);

        btn_Back = findViewById(R.id.btn_SA_Back);
        btn_Signup = findViewById(R.id.btn_SA_Signup);
        btn_Id_Check = findViewById(R.id.btn_SA_IdCheck);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sign");

        list = new ArrayList<>();

        //회원가입 버튼
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재 시간 구하기
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String indate = sdf.format(cal.getTime());

                String id = edt_Id.getText().toString();
                String pw = edt_Pw.getText().toString();
                String repw = edt_Repw.getText().toString();
                String name = edt_Name.getText().toString();
                String phone = edt_Phone.getText().toString();
                String email = edt_Email.getText().toString();
                String address = edt_Address.getText().toString();

                if(pw.equals(repw)){
                    //signVO에 있는 singVO 형식에 맞춰서 작성 -> 데이터등록
                    myRef.push().setValue(new SignVO(
                            id,
                            pw,
                            name,
                            phone,
                            email,
                            address,
                            indate
                    ));
                    Toast.makeText(SignActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignActivity.this, LoginActivity.class);
                    startActivity(intent);
               }else {
                    Toast.makeText(SignActivity.this, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });



        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                SignVO vo = snapshot.getValue(SignVO.class);
                list.add(vo);


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


        btn_Id_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            DataSnapshot snapshot = task.getResult();

                            for(DataSnapshot data : snapshot.getChildren()){

                                SignVO vo = data.getValue(SignVO.class);

                                Log.d("firebase", vo.toString());
                                
                                //아이디 중복체크 로직
                                if(edt_Id.getText().toString().equals(vo.getId().toString())) {
                                    Toast.makeText(SignActivity.this,
                                            "중복된 아이디 입니다",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(SignActivity.this,
                                            "사용하실 수 있는 아이디 입니다.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }


                        }
                    }
                });
            }
        });


        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
}
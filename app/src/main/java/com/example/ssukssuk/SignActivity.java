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

import com.example.ssukssuk.VO.signVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SignActivity extends AppCompatActivity {
    EditText edt_Name,edt_Id,edt_Pw,edt_Repw,edt_Phone,edt_Email,edt_Address;
//    Spinner year,month,day;
//    int month_sel;
    Button btn_Id_check,btn_Back,btn_signup;

    ArrayList<signVO> list;





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
        btn_signup = findViewById(R.id.btn_SA_Signup);
        btn_Id_check = findViewById(R.id.btn_SA_IdCheck);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sign");

        list = new ArrayList<>();
//        year = (Spinner) findViewById(R.id.signBirth);
//        month =(Spinner) findViewById(R.id.signBirth2);
//        day = (Spinner) findViewById(R.id.signBirth3);

//        final ArrayList<String> list = new ArrayList<>();
//        final ArrayList<String> list2 = new ArrayList<>();
//        final ArrayList<String> list3 = new ArrayList<>();
//        for(int i = 2022; i>=1950;i--){
//            list.add(String.valueOf(i));
//        }
//        for(month_sel = 1; month_sel<=12;month_sel++) {
//            list2.add(String.valueOf(month_sel));
//           /* if((i == 1 )||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)){
//                for(int j = 1; j<=31; j++){
//                    list3.
//                }
//            }else if((i==2)){
//
//            }else{
//
//            }*/
//        }
//            if(month_sel == 2){
//                for(int j = 1; j<=28;j++){
//                  list3.add(String.valueOf(j));
//                }
//            }
//            else{
//                for(int j = 1; j<=31;j++){
//                    list3.add(String.valueOf(j));
//                }
//            }
//
//
//        ArrayAdapter spinnerAdapter;
//        spinnerAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
//        year.setAdapter(spinnerAdapter);
//
//
//        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SignActivity.this,""+year.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        ArrayAdapter spinnerAdapter2;
//        spinnerAdapter2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list2);
//        month.setAdapter(spinnerAdapter2);
//
//        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SignActivity.this,""+month.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        ArrayAdapter spinnerAdapter3;
//        spinnerAdapter3 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list3);
//        day.setAdapter(spinnerAdapter3);
//
//        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SignActivity.this,""+day.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        //회원가입 버튼
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재 시간 구하기
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String indate = sdf.format(cal.getTime());

                String id = edt_Id.getText().toString();
                String pw = edt_Pw.getText().toString();String
                repw = edt_Repw.getText().toString();
                String name = edt_Name.getText().toString();
                String phone = edt_Phone.getText().toString();
                String email = edt_Email.getText().toString();
                String address = edt_Address.getText().toString();

                if(pw.equals(repw)){
                    //signVO에 있는 singVO 형식에 맞춰서 작성 -> 데이터등록
                    myRef.push().setValue(new signVO(
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

                signVO vo = snapshot.getValue(signVO.class);
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


        btn_Id_check.setOnClickListener(new View.OnClickListener() {
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

                                signVO vo = data.getValue(signVO.class);

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
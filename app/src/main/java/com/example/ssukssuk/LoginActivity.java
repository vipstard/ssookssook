package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssukssuk.Find.Id.IdFindActivity;
import com.example.ssukssuk.Find.Pw.PwFindActivity;
import com.example.ssukssuk.VO.loginVO;
import com.example.ssukssuk.VO.signVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_sign,btn_idfind,btn_pwfind;
    EditText user_id, user_pw;
    CheckBox auto_check;
    String loginId,loginPw;
    loginVO vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sign");
        vo = new loginVO();

        user_id = findViewById(R.id.user_id);
        user_pw = findViewById(R.id.user_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_sign = findViewById(R.id.btn_sign);
        btn_idfind = findViewById(R.id.btn_idfind);
        btn_pwfind = findViewById(R.id.btn_pwfind);
        auto_check = findViewById(R.id.cbauto);

        SharedPreferences spf = LoginActivity.this.
                getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        //editor 실행시키는?
        SharedPreferences.Editor editor = spf.edit();
        loginId = LoginActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id",null);
        loginPw = LoginActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_pw",null);




        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                loginVO vo = snapshot.getValue(loginVO.class);
                if(loginId !=null && loginPw != null) {
                    if(loginId.equals(vo.getId().toString())&&loginPw.equals(vo.getPw().toString())){
                        Toast.makeText(LoginActivity.this, loginId +"님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }


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
            btn_login.setOnClickListener(new View.OnClickListener() {
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

                                    loginVO vo = data.getValue(loginVO.class);

                                    Log.d("firebase", vo.toString());

                                    //아이디 중복체크 로직
                                    if(user_id.getText().toString().equals(vo.getId().toString())&&user_pw.getText().toString().equals(vo.getPw().toString())) {
                                        if(auto_check.isChecked()) {
                                            SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                                            Toast.makeText(LoginActivity.this, "여기까지 ok", Toast.LENGTH_SHORT).show();
                                            editor.putString("user_login_id", user_id.getText().toString());
                                            editor.putString("user_login_pw", user_pw.getText().toString());
                                            editor.commit();
                                        }
                                        Toast.makeText(LoginActivity.this,"로그인 성공",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);




                                    }
                                    else {
                                        Toast.makeText(LoginActivity.this,
                                                "로그인 실패",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
            });



//
//                    if (user_id.getText().toString().equals("hh") && user_pw.getText().toString().equals("hh")) {
//                        if(auto_check.isChecked()) {
//
//                            SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
//                            Toast.makeText(LoginActivity.this, "여기까지 ok", Toast.LENGTH_SHORT).show();
//
//                            editor.putString("user_login_id", user_id.getText().toString());
//                            editor.putString("user_login_pw", user_id.getText().toString());
//                            editor.commit();
//                            //꼭 commit()을 해줘야 값이 저장됩니다 ㅎㅎ
//
//
//                            Toast.makeText(LoginActivity.this, user_id.getText().toString() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//
//                            startActivity(intent);
//                            finish();
//                        }else{
//                            SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
//                            Toast.makeText(LoginActivity.this, "여기까지 ok", Toast.LENGTH_SHORT).show();
//
//                            editor.putString("user_login_id", user_id.getText().toString());
//                            Toast.makeText(LoginActivity.this, user_id.getText().toString() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//
//                            startActivity(intent);
//                            finish();
//                        }
//
//                    } else {
//                        Toast.makeText(LoginActivity.this,
//                                "로그인 실패",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });


        btn_idfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, IdFindActivity.class);
                startActivity(intent);
            }
        });
        btn_pwfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, PwFindActivity.class);
                startActivity(intent);
            }
        });


        btn_sign.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LoginActivity.this, SignActivity.class);

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

    //현재 페이지에서 뒤로가기 막는 기능
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}
package com.example.ssukssuk.ServiceCenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.ServiceCenter.VO.ScVO;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ScListViewActivity extends AppCompatActivity {

    TextView tv_Title, tv_Post;
    Button btn_Edit, btn_Delete;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ServiceCenter");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_list_view);

        tv_Title = findViewById(R.id.tv_SLVA_Title);
        tv_Post = findViewById(R.id.tv_SLVA_Post);
        btn_Delete = findViewById(R.id.btn_SLVA_Delete);
        btn_Edit = findViewById(R.id.btn_SLVA_Edit);



        Intent intent = getIntent();
        String title = intent.getStringExtra("SCtitle");


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                ScVO vo = snapshot.getValue(ScVO.class);

                //LoginActivity에서 user_login_id1에 저장한 로그인 아이디를 writer에 삽입
                String writer = ScListViewActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id1", null);


                //로그인한 아이디와 데이터베이스에 있는 아이디가 같고 & 적힌 제목과 데이터베이스에 있는 제목이 같으면 if문 실행
                //여기서 for문이 값 하나에서 멈춰있음!!

                if (writer.equals(vo.getWriter()) && title.equals(vo.getTitle())) {
                    //tv_Title에 데이터베이스에 있는 Title 값을 출력
                    tv_Title.setText(vo.getTitle());
                    //tv_Post에 데이터베이스에 있는 Title 값을 출력
                    tv_Post.setText(vo.getPost());

                    // 키 값 가져온 후 저장한다
                    String a = snapshot.getKey();



                    //멈춰있는 for문 값에서 버튼 기능 실행
                    btn_Delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //해당 키값에 데이터를 삭제한다
                            myRef.child(a).removeValue();

                            //화면이동
                            startActivity(new Intent(ScListViewActivity.this, MainActivity.class));

                        }

                    });
                    btn_Edit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1 =  new Intent(ScListViewActivity.this, ScEditActivity.class);
                            intent1.putExtra("ScTitle1",vo.getTitle());
                            startActivity(intent1);
                        }
                    });

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

//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                @Override
//                public void onComplete (@NonNull Task < DataSnapshot > task) {
//                    if (!task.isSuccessful()) {
//                        Log.e("firebase", "Error getting data", task.getException());
//                    } else {
//                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                        DataSnapshot snapshot = task.getResult();
//
//                        for (DataSnapshot data : snapshot.getChildren()) {
//
//                            ScVO vo = data.getValue(ScVO.class);
//
//                            String writer = ScListViewActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
//                                    getString("user_login_id1", null);
//
//                            if (writer.equals(vo.getWriter()) && title.equals(vo.getTitle())) {
//                                tv_Title.setText(vo.getTitle());
//                                tv_Post.setText(vo.getPost());
//
//
//                            }
//                        }
//
//                    }
//                }
//            });


//        btn_Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                myRef.child(title).removeValue();
//                startActivity(new Intent(ScListViewActivity.this, ScEditActivity.class));
//            }
//
//        });



    }
}
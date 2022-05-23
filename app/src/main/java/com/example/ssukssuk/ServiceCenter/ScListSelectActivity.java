package com.example.ssukssuk.ServiceCenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.ServiceCenter.VO.ScAnswerAdapter;
import com.example.ssukssuk.ServiceCenter.VO.ScAnswerVO;
import com.example.ssukssuk.ServiceCenter.VO.ScVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ScListSelectActivity extends AppCompatActivity {

    TextView tv_title, tv_content, tv_date;
    Button btn_edit, btn_delete, btn_content;
    ListView lv;
    ArrayList<ScAnswerVO> list;
    ScAnswerAdapter adapter;
    ImageButton btn_back;

    int cnt = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ServiceCenter");
    DatabaseReference myRef1 = database.getReference("Sc_answer");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_list_select);

        tv_title = findViewById(R.id.tv_SLSA_Title);
        tv_content = findViewById(R.id.tv_SLSA_Content);
        tv_date = findViewById(R.id.tv_SLSA_Date);
        btn_delete = findViewById(R.id.btn_SLSA_Delete);
        btn_edit = findViewById(R.id.btn_SLSA_Edit);
        btn_content = findViewById(R.id.btn_SLSA_Content);
        lv = findViewById(R.id.Sc_list_answer_list);
        btn_back = findViewById(R.id.btn_SLSA_Back);

        String title = ScListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Sctitle", null);
        String writer = ScListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        String indate = ScListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Scindate", null);

        list = new ArrayList<ScAnswerVO>();

        tv_title.setText(title);
        tv_date.setText(indate);


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                ScVO vo = snapshot.getValue(ScVO.class);


                //로그인한 아이디와 데이터베이스에 있는 아이디가 같고 & 적힌 제목과 데이터베이스에 있는 제목이 같으면 if문 실행
                //여기서 for문이 값 하나에서 멈춰있음!!


                if (writer.equals(vo.getWriter()) && title.equals(vo.getTitle())) {
                    //tv_Title에 데이터베이스에 있는 Title 값을 출력
                    tv_title.setText(vo.getTitle());
                    //tv_Post에 데이터베이스에 있는 Title 값을 출력
                    tv_content.setText(vo.getContent());

                    // 키 값 가져온 후 저장한다
                    String a = snapshot.getKey();


                    //멈춰있는 for문 값에서 버튼 기능 실행
                    btn_delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            myRef1.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {

                                    if (!task.isSuccessful()) {
                                        Log.e("firebase", "Error getting data", task.getException());
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        DataSnapshot snapshot = task.getResult();
                                        for (DataSnapshot data1 : snapshot.getChildren()) {

                                            ScVO vo = data1.getValue(ScVO.class);
                                            if (title.equals(vo.getTitle())) {
                                                String b = data1.getKey();
                                                myRef1.child(b).removeValue();
                                            }

                                        }
                                    }
                                }
                            });
                            //해당 키값에 데이터를 삭제한다
                            myRef.child(a).removeValue();

                            //화면이동
                            startActivity(new Intent(ScListSelectActivity.this, MainActivity.class));

                        }

                    });
                    btn_edit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1 = new Intent(ScListSelectActivity.this, ScEditActivity.class);
                            intent1.putExtra("ScTitle1", vo.getTitle());
                            startActivity(intent1);
                        }
                    });
                    btn_content.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(ScListSelectActivity.this, ScAnswerWriteActivity.class));
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

        //리스트에서 Board_answer에서 댓글 정보 가져오기
        myRef1.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override

            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();
                    if (cnt == 0) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            ScVO vo = data.getValue(ScVO.class);
                            if (title.equals(vo.getTitle())) {
                                String writer1 = vo.getWriter();
                                String date = vo.getDate();
                                String content1 = vo.getContent();
                                list.add(new ScAnswerVO(date, content1, writer1));
                            }
                            adapter.notifyDataSetChanged();
                        }
                        cnt++;
                    }

                }
            }
        });
        adapter = new ScAnswerAdapter(
                ScListSelectActivity.this,
                R.layout.sc_answer_list,
                list
        );

        lv.setAdapter(adapter);


    }
}
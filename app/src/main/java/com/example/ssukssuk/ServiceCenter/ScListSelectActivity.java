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


                //???????????? ???????????? ????????????????????? ?????? ???????????? ?????? & ?????? ????????? ????????????????????? ?????? ????????? ????????? if??? ??????
                //????????? for?????? ??? ???????????? ????????????!!


                if (writer.equals(vo.getWriter()) && title.equals(vo.getTitle())) {
                    //tv_Title??? ????????????????????? ?????? Title ?????? ??????
                    tv_title.setText(vo.getTitle());
                    //tv_Post??? ????????????????????? ?????? Title ?????? ??????
                    tv_content.setText(vo.getContent());

                    // ??? ??? ????????? ??? ????????????
                    String a = snapshot.getKey();


                    //???????????? for??? ????????? ?????? ?????? ??????
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
                            //?????? ????????? ???????????? ????????????
                            myRef.child(a).removeValue();

                            //????????????
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

        //??????????????? Board_answer?????? ?????? ?????? ????????????
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
package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ssukssuk.Board_answerVO.Board_answer_Adapter;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.VO.Board_list_select_writeVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class BoardListSelectActivity extends AppCompatActivity {
    Button btn_answer, btn_delete, btn_edit;
    TextView tv_title, tv_content, tv_writer,tv_date;
    ImageButton btn_back;
    ArrayList<Board_list_select_writeVO> list;
    Board_answer_Adapter adapter;
    ListView lv;
    int cnt = 0;
    ImageView img;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");
    DatabaseReference myRef1 = database.getReference("Board_answer");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list_select);

        btn_back = findViewById(R.id.btn_BLSA_Back);
        btn_answer = findViewById(R.id.btn_BLSA_Answer);
        btn_edit = findViewById(R.id.btn_BLSA_Edit);
        btn_delete = findViewById(R.id.btn_BLSA_Delete);
        tv_title = findViewById(R.id.board_title2);
        tv_content = findViewById(R.id.tv_BLSA_Content);
        tv_writer = findViewById(R.id.tv_BLSA_Writer);
        tv_date = findViewById(R.id.tv_BLSA_Date);
        lv = findViewById(R.id.board_list_answer_list);
        img = findViewById(R.id.iv_BLSA_picture);

        String title = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("title", null);
        String writer = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("writer", null);
        String indate = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("indate", null);

        list = new ArrayList<Board_list_select_writeVO>();


        tv_title.setText(title);
        tv_date.setText(indate);
        tv_writer.setText(writer);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://ssukssuk-af5d6.appspot.com/");
        StorageReference storageRef = storage.getReference();
        storageRef.child("images/"+writer + indate + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //????????? ?????? ?????????
//                Toast.makeText(getApplicationContext(), "??????", Toast.LENGTH_SHORT).show();
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img);

            }

        });


        //?????? Board?????? ?????? ?????? ???????????? ????????????
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();
                    for (DataSnapshot data : snapshot.getChildren()) {

                        BoardVO vo = data.getValue(BoardVO.class);

                        //???????????? ???????????? ????????????????????? ?????? ???????????? ?????? & ?????? ????????? ????????????????????? ?????? ????????? ????????? if??? ??????
                        //????????? for?????? ??? ???????????? ????????????!!

                        if (title.equals(vo.getTitle()) && indate.equals(vo.getDate())) {
                            String content = vo.getContent();
                            tv_content.setText(content);

                            // ??? ??? ????????? ??? ????????????
                            String a = data.getKey();

                            //????????????(????????? ????????? ?????? ????????? ??? ??????)
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

                                                    BoardVO vo = data1.getValue(BoardVO.class);

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
                                    startActivity(new Intent(BoardListSelectActivity.this, MainActivity.class));
                                }
                            });

                            btn_edit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(BoardListSelectActivity.this,BoardEditActivity.class));
                                }
                            });
                        }
                    }


                }
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
                            BoardVO vo = data.getValue(BoardVO.class);
                            BoardVO vo1 = new BoardVO();
                            if (title.equals(vo.getTitle())) {
                                String writer1 = vo.getWriter();
                                String date = vo.getDate();
                                String content1 = vo.getContent();
                                list.add(new Board_list_select_writeVO(date, content1, writer1));
                            }
                            adapter.notifyDataSetChanged();
                        }
                        cnt++;
                    }

                }
            }
        });
        adapter = new Board_answer_Adapter(
                BoardListSelectActivity.this,
                R.layout.answer_list,
                list
        );
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content = list.get(i).getContent();
                String writer = list.get(i).getWriter();
                String indate = list.get(i).getDate();
                myRef1.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        } else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            DataSnapshot snapshot = task.getResult();
                            for (DataSnapshot data1 : snapshot.getChildren()) {

                                BoardVO vo = data1.getValue(BoardVO.class);
                                if (title.equals(vo.getTitle())&&content.equals(vo.getContent())&&writer.equals(vo.getWriter())&&indate.equals(vo.getDate())) {
                                    String b = data1.getKey();
                                    myRef1.child(b).removeValue();

                                    Toast.makeText(getApplicationContext(),"?????????????????????", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    }
                });
                return true;
            }
        });

        //?????? ???????????? ??????
        btn_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardListSelectActivity.this, Board_answer.class);
                startActivity(intent);

            }
        });
    }


}
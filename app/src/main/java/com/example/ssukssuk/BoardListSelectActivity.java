package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ssukssuk.Board_answerVO.Board_answer_Adapter;
import com.example.ssukssuk.Board_answerVO.Board_answer_VO;
import com.example.ssukssuk.ServiceCenter.ScEditActivity;
import com.example.ssukssuk.ServiceCenter.ScListSelectActivity;
import com.example.ssukssuk.VO.BoardVO_content;
import com.example.ssukssuk.VO.Board_list_select_writeVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BoardListSelectActivity extends AppCompatActivity {
    Button btn_answer, btn_delete, btn_edit;
    TextView tv_title, tv_content, tv_writer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");
    DatabaseReference myRef1 = database.getReference("Board_answer");
    String title = "";
    String content = "";
    String writer = "";
    ArrayList<Board_list_select_writeVO> list;
    Board_answer_Adapter adapter;
    String writer1 = "";
    String content1 = "";
    String date = "";
    ListView lv;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list_select);

        btn_answer = findViewById(R.id.btn_BLSA_Answer);
        btn_edit = findViewById(R.id.btn_BLSA_Edit);
        btn_delete = findViewById(R.id.btn_BLSA_Delete);
        tv_title = findViewById(R.id.board_title2);
        tv_content = findViewById(R.id.board_content2);
        tv_writer = findViewById(R.id.board_wirte2);
        lv = findViewById(R.id.board_list_answer_list);

        title = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("title", null);
        String loginkey = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("login_key", null);
        String writer = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        String indate = BoardListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("indate", null);

        list = new ArrayList<Board_list_select_writeVO>();

        tv_title.setText(title);
        tv_writer.setText(writer);

        //댓글 작성하기 버튼
        btn_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardListSelectActivity.this, Board_answer.class);
                startActivity(intent);
            }
        });

        //데베 Board에서 댓글 내용 가져와서 출력하기
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();
                    for (DataSnapshot data : snapshot.getChildren()) {

                        BoardVO_content vo = data.getValue(BoardVO_content.class);

                        content = vo.getContent();
                        tv_content.setText(content);


                        //로그인한 아이디와 데이터베이스에 있는 아이디가 같고 & 적힌 제목과 데이터베이스에 있는 제목이 같으면 if문 실행
                        //여기서 for문이 값 하나에서 멈춰있음!!

                        if (title.equals(vo.getTitle()) && indate.equals(vo.getDate())) {
                            Log.d("titleada",title);
                            Log.d("titleada3",vo.getTitle());
                            Log.d("titleada4",indate);
                            Log.d("titleada2",vo.getDate());
                            //tv_Title에 데이터베이스에 있는 Title 값을 출력
                            tv_title.setText(vo.getTitle());
                            //tv_Post에 데이터베이스에 있는 Title 값을 출력
                            tv_content.setText(vo.getContent());

                            // 키 값 가져온 후 저장한다
                            String a = data.getKey();

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

                                                    if (title.equals(vo.getTitle())) {
                                                        myRef1.child(data1.getKey()).removeValue();
                                                    }
                                                }
                                            }
                                        }
                                    });
                                    //해당 키값에 데이터를 삭제한다
                                    myRef.child(a).removeValue();

                                    //화면이동
                                    startActivity(new Intent(BoardListSelectActivity.this, MainActivity.class));

                                }
                            });

                            btn_edit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent1 = new Intent(BoardListSelectActivity.this, BoardEditActivity.class);
                                    intent1.putExtra("ScTitle1", vo.getTitle());
                                    startActivity(intent1);

                                }
                            });
                        }
                    }


                }
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
                            Board_answer_VO vo = data.getValue(Board_answer_VO.class);
                            BoardVO_content vo1 = new BoardVO_content();
                            if (title.equals(vo.getTitle())) {
                                writer1 = vo.getWriter();
                                date = vo.getDate();
                                content1 = vo.getContent();
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
    }
}

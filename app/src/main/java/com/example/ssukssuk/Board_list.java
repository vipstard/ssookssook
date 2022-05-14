package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.Board_answerVO.Board_answer_Adapter;
import com.example.ssukssuk.Board_answerVO.Board_answer_VO;
import com.example.ssukssuk.Plant_reg.PlantAdapter;
import com.example.ssukssuk.Plant_reg.Reg_Plant_mainVO;
import com.example.ssukssuk.ServiceCenter.ScEditActivity;
import com.example.ssukssuk.ServiceCenter.ScListViewActivity;
import com.example.ssukssuk.ServiceCenter.ScVO;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Board_list extends AppCompatActivity {
    Button btn_rp;
    TextView tv_title,tv_content,tv_writer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");
    DatabaseReference myRef1 = database.getReference("Board_answer");
    String title = "";
    String content = "";
    String writer = "";
    ArrayList<Board_answer_VO> list;
    Board_answer_Adapter adapter;
    String writer1 = "";
    String content1 = "";
    String date = "";
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list);

        btn_rp = findViewById(R.id.btn_board_rp);
        tv_title = findViewById(R.id.board_title2);
        tv_content = findViewById(R.id.board_content2);
        tv_writer = findViewById(R.id.board_wirte2);
        lv = findViewById(R.id.board_list_answer_list);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        writer = intent.getStringExtra("writer");

        list = new ArrayList<Board_answer_VO>();
        tv_title.setText(title);
        tv_writer.setText(writer);


        btn_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board_list.this,Board_answer.class);
                startActivity(intent);
            }
        });
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
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
                            }

                        }
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
        myRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                myRef1.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override

                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        } else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            DataSnapshot snapshot = task.getResult();

                            for (DataSnapshot data : snapshot.getChildren()) {

                                Board_answer_VO vo = data.getValue(Board_answer_VO.class);
                                writer1 = vo.getWriter();
                                date = vo.getDate();
                                content1 = vo.getContent();
                                list.add(new Board_answer_VO(date, content1, writer1));
                                adapter.notifyDataSetChanged();
                            }

                        }
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
        adapter = new Board_answer_Adapter(
                Board_list.this,
                R.layout.answer_list,
                list
        );
        lv.setAdapter(adapter);
    }
}
package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Board_list extends AppCompatActivity {
    Button btn_rp;
    TextView tv_title,tv_content,tv_writer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list);

        btn_rp = findViewById(R.id.btn_board_rp);
        tv_title = findViewById(R.id.board_title2);
        tv_content = findViewById(R.id.board_content2);
        tv_writer = findViewById(R.id.board_wirte2);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv_title.setText(title);

//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                } else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                    DataSnapshot snapshot = task.getResult();
//
//                    for (DataSnapshot data : snapshot.getChildren()) {
//
//                        BoardVO_content vo = data.getValue(BoardVO_content.class);
//                        writer = vo.getWriter();
//                        title = vo.getTitle();
//                        date = vo.getDate();
//                        list.add(new BoardVO(writer,title,date));
//                        list2.add(new BoardVO(writer,title,date));
//                        adapter.notifyDataSetChanged();
//                        Toast.makeText(getActivity(),writer,Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }
//        });
    }
}
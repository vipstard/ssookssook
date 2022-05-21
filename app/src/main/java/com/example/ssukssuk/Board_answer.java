package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ssukssuk.Board.BoardVO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Board_answer extends AppCompatActivity {
    Button btn_as;
    EditText edt_content, edt_title;
    ImageButton btn_back;
    String title;
    String content;
    String writer;
    String indate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_answer);
        btn_as = findViewById(R.id.btn_board_asnwer_btn);
        edt_content = findViewById(R.id.edt_BAA_Content);
        btn_back = findViewById(R.id.btn_BAA_Back);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Board_answer");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board_answer.this, BoardListSelectActivity.class);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                indate = sdf.format(cal.getTime());

                content = edt_content.getText().toString();
//                SharedPreferences spf = Board_answer.this.
//                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
//                title = intent.getStringExtra("title");
                title = Board_answer.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("title", null);
                writer = Board_answer.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("writer", null);

                myRef.push().setValue(new BoardVO(
                        indate,
                        content,
                        writer,
                        title
                ));

                startActivity(intent);
            }

        });
    }
}
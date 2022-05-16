package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.Board_answerVO.Board_answer_VO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Board_answer extends AppCompatActivity {
    Button btn_as;
    EditText edt_content,edt_title;
    String title;
    String content;
    String writer;
    String indate;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board_answer");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_answer);
        btn_as = findViewById(R.id.btn_board_asnwer_btn);
        edt_content = findViewById(R.id.edt_board_content);
        Intent intent = getIntent();

        btn_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                indate = sdf.format(cal.getTime());
                content = edt_content.getText().toString();
                SharedPreferences spf = Board_answer.this.
                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                title = intent.getStringExtra("title");
                writer = Board_answer.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id", null);
                myRef.push().setValue(new Board_answer_VO(
                        indate,
                        content,
                        writer,
                        title));
                Intent intent = new Intent(Board_answer.this, Board_list_select.class);
                startActivity(intent);
            }

        });
    }
}
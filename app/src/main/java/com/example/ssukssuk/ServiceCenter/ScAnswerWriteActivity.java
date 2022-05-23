package com.example.ssukssuk.ServiceCenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.BoardListSelectActivity;
import com.example.ssukssuk.Board_answer;
import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.ServiceCenter.VO.ScVO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScAnswerWriteActivity extends AppCompatActivity {

    Button btn_write;
    EditText edt_content;
    ImageButton btn_back;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Sc_answer");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_answer_write);

        btn_back = findViewById(R.id.btn_SAWA_Back);
        btn_write = findViewById(R.id.btn_SAWA_Write);
        edt_content = findViewById(R.id.edt_SAWA_Content);
        String writer = ScAnswerWriteActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        String title = ScAnswerWriteActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Sctitle", null);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String indate = sdf.format(cal.getTime());

                String content = edt_content.getText().toString();

                myRef.push().setValue(new ScVO(
                        writer,
                        title,
                        content,
                        indate
                ));
                startActivity(new Intent(ScAnswerWriteActivity.this, MainActivity.class));
            }
        });
    }
}
package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.ServiceCenter.ScWriteActivity;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BoardWriteActivity extends AppCompatActivity {

    EditText edt_title,edt_content;
    Button btn_reg;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        edt_title = findViewById(R.id.edt_board_write_title);
        edt_content = findViewById(R.id.edt_board_write_content);
        btn_reg = findViewById(R.id.button6);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edt_title.getText().toString();
                String content = edt_content.getText().toString();

                String writer = BoardWriteActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id1",null);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String indate = sdf.format(cal.getTime());

                myRef.push().setValue(new BoardVO_content(
                        title,
                        content,
                        writer,
                        indate));
                Intent intent1 = new Intent(BoardWriteActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}
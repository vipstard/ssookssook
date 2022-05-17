package com.example.ssukssuk.ServiceCenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.ServiceCenter.VO.ScVO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScWriteActivity extends AppCompatActivity {

    Button btn_write;
    EditText edt_title, edt_content;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ServiceCenter");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_write);

        btn_write = findViewById(R.id.btn_SWA_Write);
        edt_title = findViewById(R.id.edt_SWA_Title);
        edt_content = findViewById(R.id.edt_SWA_Content);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScWriteActivity.this,MainActivity.class);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(cal.getTime());

                String title = edt_title.getText().toString();
                String content = edt_content.getText().toString();
                String writer = ScWriteActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id1",null);


                myRef.push().setValue(new ScVO(
                        title,
                        content,
                        date,
                        writer
                ));
                startActivity(intent);

            }
        });

    }
}
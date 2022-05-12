package com.example.ssukssuk.ServiceCenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssukssuk.LoginActivity;
import com.example.ssukssuk.MainActivity;
import com.example.ssukssuk.R;
import com.example.ssukssuk.VO.BoardVO_content;
import com.example.ssukssuk.VO.loginVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ScWriteActivity extends AppCompatActivity {

    Button btn_write;
    EditText edt_Title, edt_Post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_write);

        btn_write = findViewById(R.id.btn_SWA_Write);
        edt_Title = findViewById(R.id.edt_SWA_Title);
        edt_Post = findViewById(R.id.edt_SWA_Post);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SC");




        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScWriteActivity.this,MainActivity.class);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String date = sdf.format(cal.getTime());

                String title = edt_Title.getText().toString();
                String post = edt_Post.getText().toString();

                String writer = ScWriteActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id1",null);

                myRef.push().setValue(new ServiceVO(
                        title,
                        post,
                        date,
                        writer
                ));
                startActivity(intent);

            }
        });

    }
}
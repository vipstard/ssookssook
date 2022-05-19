package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.VO.Board_list_select_writeVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class DiaryActivity2 extends AppCompatActivity {
    TextView dia_title;
    TextView dia_content;
    Button btn_reg;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference myRef = database.getReference("Diary");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        btn_reg = findViewById(R.id.diary_re);
        String title = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_title", null);
        String writer =DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_writer", null);
        String date = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_date", null);
        String content = DiaryActivity2.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_content", null);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryActivity2.this,diary_select_edit.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();


        Toast.makeText(DiaryActivity2.this,date,Toast.LENGTH_SHORT).show();
        dia_title = findViewById(R.id.diary_title);
        dia_title.setText(title);
        dia_content = findViewById(R.id.diary_content);

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

                        if (title.equals(vo.getTitle())) {
                            String content1 = vo.getContent();
                            dia_content.setText(content1);
                        }
                }
            }
        }
    });
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://ssukssuk-af5d6.appspot.com/");
        StorageReference storageRef = storage.getReference();
        storageRef.child("images/" + date + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //이미지 로드 성공시
                ImageView dia_img = findViewById(R.id.diary_picture);
                Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(dia_img);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
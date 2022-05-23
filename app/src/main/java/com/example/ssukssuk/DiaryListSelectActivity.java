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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ssukssuk.Board.BoardVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class DiaryListSelectActivity extends AppCompatActivity {
    TextView dia_title;
    TextView dia_content;
    Button btn_reg;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference myRef = database.getReference("Diary");
     ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list_select);
        btn_back = findViewById(R.id.btn_DLSA_Back);
        btn_reg = findViewById(R.id.btn_DLSA_Edit);
        String title = DiaryListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_title", null);
        String writer = DiaryListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_writer", null);
        String date = DiaryListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_date", null);
        String content1 = DiaryListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_content", null);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryListSelectActivity.this, DiaryEditActivity.class);
                startActivity(intent);
            }
        });
        dia_title = findViewById(R.id.btn_DLSA_Title);
        dia_title.setText(title);
        dia_content = findViewById(R.id.tv_DLSA_Content);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String pot_name = DiaryListSelectActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("pot_name", null);
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override

            public void onComplete(@NonNull Task<DataSnapshot> task) {
                String content ;
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();

                    for (DataSnapshot data : snapshot.getChildren()) {
                        BoardVO vo = data.getValue(BoardVO.class);
                        if (title.equals(vo.getTitle())&&pot_name.equals(vo.getPot_name())) {

                            dia_content.setText(vo.getContent());
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
                ImageView dia_img = findViewById(R.id.iv_DLSA_photo);

                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(dia_img);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시

            }
        });
    }

}
package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ssukssuk.Board.BoardVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DiaryEditActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");
    String title, writer, date, content;
    EditText edt_title, edt_content;
    Button btn_edit;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_edit);

        btn_edit = findViewById(R.id.btn_DEA_Edit);
        edt_title = findViewById(R.id.edt_DEA_Title);
        edt_content = findViewById(R.id.edt_DEA_Content);
        btn_back = findViewById(R.id.btn_DEA_Back);

        title = DiaryEditActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_title", null);
        writer = DiaryEditActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        date = DiaryEditActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_date", null);
//        content = DiaryEditActivity.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
//                getString("Diary_select_content", null);

        edt_title.setText(title);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();

                    BoardVO vo = snapshot.getValue(BoardVO.class);


                    if (title.equals(vo.getTitle())) {

                        edt_content.setText(vo.getContent());
                        btn_edit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String a = snapshot.getKey();
                                //myRef2란 변수에 키값이 a인 값을 저장해준다
                                //string myref2
                                DatabaseReference myRef2 = myRef.child(a);
                                //수정하는 글의 값을 저장
                                String Edit_content = edt_content.getText().toString();
                                String Edit_title = edt_title.getText().toString();
                                //데베 데이터 값을 변경하는 코드
                                Map<String, Object> updateMap = new HashMap<>();
                                updateMap.put("title", Edit_title);
                                updateMap.put("content", Edit_content);
                                myRef2.updateChildren(updateMap);
                                //변경시 성공을 나타내는 Log.d코드
//                            .addOnCompleteListener(task ->
//                                    Log.d("dda","update title:"+task.isSuccessful()));
//                                Toast.makeText(DiaryEditActivity.this, "??", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DiaryEditActivity.this, MainActivity.class));
                            }
                        });
                    }
                }
            }
        });
    }
}
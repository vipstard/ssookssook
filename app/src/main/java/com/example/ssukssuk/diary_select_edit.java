package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class diary_select_edit extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");
    String title, writer, date, content;
    EditText re_title, re_content;
    Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_select_edit);
//        btn_reg = findViewById(R.id.diary_select_edit_reg);
//        re_title = findViewById(R.id.editTextTextPersonName);
//        re_content = findViewById(R.id.editTextTextMultiLine2);
//
//        title = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
//                getString("Diary_select_title", null);
//        writer = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
//                getString("user_login_id1", null);
//        date = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
//                getString("Diary_select_date", null);
////        content = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
////                getString("Diary_select_content", null);
//
//        re_title.setText(title);
//
//
//
//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                } else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                    DataSnapshot snapshot = task.getResult();
//
//                    BoardVO vo = snapshot.getValue(BoardVO.class);
//
//
//                    if (title.equals(vo.getTitle())) {
//                        Log.d("dasd",vo.getTitle());
//                        Log.d("adsadasd",title);
//                        Log.d("dasdsa",vo.getContent());
//                        re_content.setText(vo.getContent());
//                        btn_reg.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                String a = snapshot.getKey();
//                                //myRef2란 변수에 키값이 a인 값을 저장해준다
//                                //string myref2
//                                DatabaseReference myRef2 = myRef.child(a);
//                                //수정하는 글의 값을 저장
//                                String Edit_content = re_content.getText().toString();
//                                String Edit_title = re_title.getText().toString();
//                                //데베 데이터 값을 변경하는 코드
//                                Map<String, Object> updateMap = new HashMap<>();
//                                updateMap.put("title", Edit_title);
//                                updateMap.put("content", Edit_content);
//                                myRef2.updateChildren(updateMap);
//                                //변경시 성공을 나타내는 Log.d코드
////                            .addOnCompleteListener(task ->
////                                    Log.d("dda","update title:"+task.isSuccessful()));
//                                Toast.makeText(diary_select_edit.this, "??", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(diary_select_edit.this, MainActivity.class));
//                            }
//                        });
//                    }
//                }
//            }
//        });
    }
}
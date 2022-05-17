package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class diary_select_edit extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");
    String title,writer,date,content;
    EditText re_title, re_content;
    Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_select_edit);
        btn_reg = findViewById(R.id.diary_select_edit_reg);
        re_title = findViewById(R.id.editTextTextPersonName);
        re_content = findViewById(R.id.editTextTextMultiLine2);

         title = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_title", null);
        writer =diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_writer", null);
        date = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_date", null);
        content = diary_select_edit.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("Diary_select_content", null);
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();
            }
        });
    }
}
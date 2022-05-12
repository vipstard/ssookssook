package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.ssukssuk.Plant_reg.PlantAdapter;

import com.example.ssukssuk.Plant_reg.Reg_Plant_mainVO;
import com.example.ssukssuk.VO.PlantVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Plant_List extends AppCompatActivity {
    ListView lv;
    PlantAdapter adapter;
    ArrayList<Reg_Plant_mainVO> list;
    Button btn_add;
    String name="";
    String date = "";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Pot");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        btn_add = findViewById(R.id.button3);
        lv = findViewById(R.id.Plant_list_Listview);
        list = new ArrayList<Reg_Plant_mainVO>();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plant_List.this,Reg_Plant_main.class);
                startActivity(intent);
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

                    for (DataSnapshot data : snapshot.getChildren()) {

                        PlantVO vo = data.getValue(PlantVO.class);
                        name = vo.getPotName();
                        date = vo.getPotDate();

                        list.add(new Reg_Plant_mainVO(name,date));

                        adapter.notifyDataSetChanged();
                        Toast.makeText(Plant_List.this,"성공",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        adapter = new PlantAdapter(
                Plant_List.this,
                R.layout.potlist,
                list
        );
        lv.setAdapter(adapter);
    }
}
package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
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
    Button btn_add,btn_reg_main;
    String name="";
    String date = "";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Pot");
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);

        btn_add = findViewById(R.id.btn_PLA_Add);
        lv = findViewById(R.id.Plant_list_Listview);
        list = new ArrayList<Reg_Plant_mainVO>();
        btn_back = findViewById(R.id.btn_PLA_Back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Plant_List.this, Reg_Plant_reg.class);
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
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Plant_List.this);

                builder.setTitle("메인 화분을").setMessage("선택하세요.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        SharedPreferences spf = Plant_List.this.
                                getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                        //editor 실행시키는?
                        SharedPreferences.Editor editor = spf.edit();

                        editor.putString("pot_name",  list.get(i).getPot_name());
                        editor.commit();
                        Toast.makeText(getApplicationContext(),list.get(i).getPot_name() , Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Toast.makeText(getApplicationContext(), "Cancel Click", Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }
}
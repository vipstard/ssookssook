package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ssukssuk.Regplant.RegAdapter;
import com.example.ssukssuk.Regplant.RegVO;

import java.util.ArrayList;

public class Reg_Plant_main extends AppCompatActivity {
    ListView reg_list1;
    Button reg_plant_add,reg_plant_delete,reg_plant_main;
    RegAdapter adapter;
    ArrayList<RegVO> list;
    ArrayList<RegVO> list2;
    String title="";
    String date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_plant_main);
        reg_list1 = findViewById(R.id.reg_list);
        reg_plant_add = findViewById(R.id.reg_plant_add);

        reg_plant_main = findViewById(R.id.reg_plant_main);
        list2 = new ArrayList<RegVO>();

        list = new ArrayList<RegVO>();
        for(int i=0; i<10; i++) {
            title = "dfdfdf" + 1;
            date = "hello";
            list.add(new RegVO(title, date));
        }

        adapter = new RegAdapter(
                Reg_Plant_main.this,
                R.layout.reg_list,
                list);
        reg_list1.setAdapter(adapter);
        reg_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Reg_Plant_main.this, "dfdfdfdfdfdfdfdfdf", Toast.LENGTH_SHORT).show();
            }
        });
        reg_plant_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count;
                count = adapter.getCount();

                // 아이템 추가.
                list.add(new RegVO(title+count,date+count));

                // listview 갱신
                adapter.notifyDataSetChanged();
            }
        });

        reg_plant_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}






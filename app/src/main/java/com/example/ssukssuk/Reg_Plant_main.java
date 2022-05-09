package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.ssukssuk.Regplant.RegAdapter;
import com.example.ssukssuk.Regplant.RegVO;

import java.util.ArrayList;

public class Reg_Plant_main extends AppCompatActivity {
    ListView reg_list1;
    Button bnt_1,btn_2;
    RegAdapter adapter;
    ArrayList<RegVO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_plant_main);
        reg_list1 = findViewById(R.id.reg_list);
       list = new ArrayList<RegVO>();


            String title = "dfdfdf"+1;
            String date = "hello";

            list.add(new RegVO(title,date));

        adapter = new RegAdapter(
                Reg_Plant_main.this,
                R.layout.reg_list,
                list);
        reg_list1.setAdapter(adapter);

    }
}






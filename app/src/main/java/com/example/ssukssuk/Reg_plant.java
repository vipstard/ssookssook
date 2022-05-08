package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssukssuk.Regplant.RegAdapter;
import com.example.ssukssuk.Regplant.RegVO;

import java.util.ArrayList;

public class Reg_plant extends AppCompatActivity {
    ListView reg_list;
    Button bnt_1,btn_2;
    RegAdapter adapter;
    ArrayList<RegVO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_plant);
        reg_list = findViewById(R.id.reg_list);
        list = new ArrayList<RegVO>();
        //리스트 ID를 동적으로 접근하는 방법

        for(int i =0; i<11; i++){
            //리소스객체접근.리소스ID반환메소드(리소스ID, 리소스타입, 패키지명)
            String title = "dfdfdf";
            String date = "hello";

            list.add(new RegVO(title,date));

        }

        adapter = new RegAdapter(
                Reg_plant.this,
                R.layout.reg_list,
                list);
        reg_list.setAdapter(adapter);

    }

    }

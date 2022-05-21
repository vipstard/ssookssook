package com.example.ssukssuk;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ssukssuk.VO.PlantVO;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reg_Plant_reg extends AppCompatActivity {
    EditText pot_name;
    Button btn_add;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_plant_main);
        pot_name = findViewById(R.id.et_pot_name);
        btn_add = findViewById(R.id.btn_pot_add);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = pot_name.getText().toString();
                Toast.makeText(Reg_Plant_reg.this, name, Toast.LENGTH_SHORT).show();
               String loginId = Reg_Plant_reg.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                       getString("user_login_id",null);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Pot");
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String indate = sdf.format(cal.getTime());

                myRef.push().setValue(new PlantVO(
                        name,
                        indate,
                        loginId));

                //인터페이스의 함수를 호출하여 변수에 저장된 값들을 Activity로 전달

                Intent intent = new Intent(Reg_Plant_reg.this,Plant_List.class);
                startActivity(intent);
            }
        });
    }
}






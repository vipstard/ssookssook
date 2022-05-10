package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignActivity extends AppCompatActivity {
    EditText name,Id,Pw,rePw,email,address;
    Spinner year,month,day;
    int month_sel;
    Button btn_Id_check,btn_Pw_check,btn_new_reg,back,btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        name = findViewById(R.id.edt_SA_Name);
        Id = findViewById(R.id.btn_SA_Id);
        Pw = findViewById(R.id.edt_SA_Pw);
        rePw = findViewById(R.id.edt_SA_Pw2);
        email = findViewById(R.id.edt_SA_Email);
        address = findViewById(R.id.edt_SA_Address);
        back = findViewById(R.id.btn_SA_Back);
        btn_signup = findViewById(R.id.btn_SA_Signup);

        year = (Spinner) findViewById(R.id.signBirth);
        month =(Spinner) findViewById(R.id.signBirth2);
        day = (Spinner) findViewById(R.id.signBirth3);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayList<String> list2 = new ArrayList<>();
        final ArrayList<String> list3 = new ArrayList<>();
        for(int i = 2022; i>=1950;i--){
            list.add(String.valueOf(i));
        }
        for(month_sel = 1; month_sel<=12;month_sel++) {
            list2.add(String.valueOf(month_sel));
           /* if((i == 1 )||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)){
                for(int j = 1; j<=31; j++){
                    list3.
                }
            }else if((i==2)){

            }else{

            }*/
        }
            if(month_sel == 2){
                for(int j = 1; j<=28;j++){
                  list3.add(String.valueOf(j));
                }
            }
            else{
                for(int j = 1; j<=31;j++){
                    list3.add(String.valueOf(j));
                }
            }


        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        year.setAdapter(spinnerAdapter);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SignActivity.this,""+year.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter spinnerAdapter2;
        spinnerAdapter2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list2);
        month.setAdapter(spinnerAdapter2);

        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SignActivity.this,""+month.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter spinnerAdapter3;
        spinnerAdapter3 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list3);
        day.setAdapter(spinnerAdapter3);

        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SignActivity.this,""+day.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_Id_check = findViewById(R.id.btn_SA_IdCheck);
        btn_Pw_check = findViewById(R.id.btn_SA_PwCheck);
        btn_new_reg = findViewById(R.id.btn_SA_Signup);
        btn_Id_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_new_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_Pw_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Pw.getText().toString().equals(rePw.getText().toString())){
                    Toast.makeText(SignActivity.this,"비번이 맞습니다.",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignActivity.this,"비번이 틀립니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignActivity.this,"클릭",Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
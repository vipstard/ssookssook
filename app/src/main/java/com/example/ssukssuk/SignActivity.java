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
    EditText name,Id,Pw,rePw,email;
    Spinner year,month,day;

    Button btn_Id_check,btn_Pw_check,btn_new_reg,back,btn_signup;
    String[] year1 = {"소녀시대", "소녀시대2", "소녀시대3", "소녀시대4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        name = findViewById(R.id.sign_name);
        Id = findViewById(R.id.signID);
        Pw = findViewById(R.id.signPW);
        rePw = findViewById(R.id.signPW2);
        email = findViewById(R.id.signmail);
        back = findViewById(R.id.btn_SA_Back);
        btn_signup = findViewById(R.id.signup_button);

        year = (Spinner) findViewById(R.id.signBirth);
        month =(Spinner) findViewById(R.id.signBirth2);
        day = (Spinner) findViewById(R.id.signBirth3);







        final ArrayList<String> list = new ArrayList<>();
        final ArrayList<String> list2 = new ArrayList<>();
        final ArrayList<String> list3 = new ArrayList<>();
        for(int i = 2022; i>=1950;i--){
            list.add(String.valueOf(i));
        }
        for(int i = 1; i<=12;i++){
            list2.add(String.valueOf(i));
           /* if((i == 1 )||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)){
                for(int j = 1; j<=31; j++){
                    list3.
                }
            }else if((i==2)){

            }else{

            }*/
        }
        for(int i = 1; i<=31;i++){
          /*  if(i ==2 ){
                list3.add()
            }*/
            list3.add(String.valueOf(i));
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
        btn_Id_check = findViewById(R.id.id_check_btn);
        btn_Pw_check = findViewById(R.id.pw_check_button);
        btn_new_reg = findViewById(R.id.signup_button);
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
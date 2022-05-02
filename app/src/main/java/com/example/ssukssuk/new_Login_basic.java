package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class new_Login_basic extends AppCompatActivity {
    EditText name,Id,Pw,rePw,email;
    Spinner year,month,day;
    TextView back;
    Button btn_Id_check,btn_Pw_check,btn_new_reg;
    String[] year1 = {"소녀시대", "소녀시대2", "소녀시대3", "소녀시대4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_basic);
        name = findViewById(R.id.sign_name);
        Id = findViewById(R.id.signID);
        Pw = findViewById(R.id.signPW);
        rePw = findViewById(R.id.signPW2);
        email = findViewById(R.id.signmail);
        back = findViewById(R.id.back);

        year = findViewById(R.id.signBirth);
        month =findViewById(R.id.signBirth2);
        day = findViewById(R.id.signBirth3);



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

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(new_Login_basic.this,"클릭",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
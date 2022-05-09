package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment5 extends Fragment {


    Button btn_logout,btn_information,btn_register;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        btn_logout = view.findViewById(R.id.btn_S_Logout);
        btn_information = view.findViewById(R.id.btn_S_Informaiton);
        btn_register = view.findViewById(R.id.btn_S_Register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"dfdf",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getActivity(),Reg_Plant_main.class);
                startActivity(intent1);
            }
        });


        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InformationActivity.class);
                startActivity(intent);
            }
        });


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spf = getActivity().
                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);

                spf.edit().remove("user_login_id").commit();
                spf.edit().remove("user_login_pw").commit();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);


            }
        });

        return view;
    }
}
package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment5 extends Fragment {


    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        // Inflate the layout for this fragment
        btn = view.findViewById(R.id.btn_S_Logout);
        btn.setOnClickListener(new View.OnClickListener() {
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
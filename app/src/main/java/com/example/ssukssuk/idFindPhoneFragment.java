package com.example.ssukssuk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class idFindPhoneFragment extends Fragment {

    EditText edtIdPhone,edtName;
    Button btnfindid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_id_find_phone, container, false);

        edtName= view.findViewById(R.id.edtName);
        edtIdPhone = view.findViewById(R.id.edtIdPhone);
        btnfindid = view.findViewById(R.id.btnFindId2);



        btnfindid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("hh")&&edtIdPhone.getText().toString().equals("hh")){
                    Intent intent = new Intent(getActivity(), TestSuccess.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(),TestFail.class);
                    startActivity(intent);
                }
            }
        });








        return view;
    }


}
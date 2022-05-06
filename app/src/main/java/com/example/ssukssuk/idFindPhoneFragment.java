package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class idFindPhoneFragment extends Fragment {


    EditText edtIdPhone,edtName;
    Button btnFindid;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_id_find_phone, container, false);

        edtName= view.findViewById(R.id.edtName);
        edtIdPhone = view.findViewById(R.id.edtIdPhone);
        btnFindid = view.findViewById(R.id.btnFindId2);



        btnFindid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("hh")&&edtIdPhone.getText().toString().equals("hh")){

                    //
                    String data = edtName.getText().toString();


                    Intent intent = new Intent(getActivity(),IdFindSuccessActivity.class);
                    intent.putExtra("data",data);
                    intent.putExtra("num","10");
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
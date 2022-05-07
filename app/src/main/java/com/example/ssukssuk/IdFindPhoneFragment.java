package com.example.ssukssuk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class IdFindPhoneFragment extends Fragment {

    EditText edtIdPhone,edtName;
    Button btnFindId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_id_find_phone, container, false);

        edtName= view.findViewById(R.id.edt_PFE_Name);
        edtIdPhone = view.findViewById(R.id.edt_IFP_Phone);
        btnFindId = view.findViewById(R.id.btn_IFP_IdFind);

        Intent intent = new Intent(getActivity(),IdFindSuccessActivity.class);
        intent.putExtra("head","로그인");

        //btnFindid 클릭시 반응하는 메서드
        btnFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("hh")&&edtIdPhone.getText().toString().equals("hh")){

                    //edtName에 적은 값 가져오기
                    String data = edtName.getText().toString();
                    //지금 페이지에서 IdFindSuccessActivity 로 이동
//                    Intent intent = new Intent(getActivity(),IdFindSuccessActivity.class);
                    //"data"라는 변수에 data의 정보를 저장
                    intent.putExtra("data",data);
                    //"num"라는 변수에 10의 정보를 저장
                    intent.putExtra("num","10");
                    //intent변수의 기능 실행
                    startActivity(intent);
                }else{
                    //지금 페이지에서 IdFindFailActivity로 이동
                    Intent intent = new Intent(getActivity(),IdFindFailActivity.class);
                    //intent변수의 기능 실행
                    startActivity(intent);
                }
            }
        });









        return view;
    }


}
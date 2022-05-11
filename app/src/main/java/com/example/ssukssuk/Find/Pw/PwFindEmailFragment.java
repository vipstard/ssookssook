package com.example.ssukssuk.Find.Pw;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.R;


public class PwFindEmailFragment extends Fragment {

    Button btnFindPw;
    EditText edtName, edtId, edtEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pw_find_email, container, false);

        edtName= view.findViewById(R.id.edt_PFE_Name);
        edtEmail = view.findViewById(R.id.edt_PFE_Email);
        edtId = view.findViewById(R.id.edt_PFE_Id);
        btnFindPw = view.findViewById(R.id.btn_PFE_PwFind);


        //btnFindid 클릭시 반응하는 메서드
        btnFindPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("hh")&&edtId.getText().toString().equals("hh")&&edtEmail.getText().toString().equals("hh")){

                    //edtName에 적은 값 가져오기
                    String data = edtName.getText().toString();
                    //지금 페이지에서 IdFindSuccessActivity 로 이동
                    Intent intent = new Intent(getActivity(),PwFindSuccessActivity.class);
                    //"data"라는 변수에 data의 정보를 저장
                    intent.putExtra("data",data);
                    //intent변수의 기능 실행
                    startActivity(intent);
                }else{
                    //지금 페이지에서 IdFindFailActivity로 이동
                    Intent intent = new Intent(getActivity(), PwFindFailActivity.class);
                    //intent변수의 기능 실행
                    startActivity(intent);
                }
            }
        });



        return view;
    }

}
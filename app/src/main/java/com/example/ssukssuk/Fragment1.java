package com.example.ssukssuk;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment1 extends Fragment {
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    EditText edtData;
    Button btn_register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        MainActivity activity = (MainActivity)getActivity();

        edtData = view.findViewById(R.id.edt);
        btn_register = view.findViewById(R.id.btn_register);

        lv = view.findViewById(R.id.lv);
        list = new ArrayList<String>();
        list.add("벤치프레스");
        list.add("인클라인 벤치프레스");
        list.add("시티드 로우");
        list.add("데드리프트");
        list.add("바벨로우");
        list.add("덤벨 프레스");
        list.add("레그 프레스");
        list.add("스쿼트");
        list.add("플라이");
        list.add("프로틴");
        list.add("단백질");
        list.add("스테로이드");
        //new ArrayAdapter<String>(현재 액티비티명.this, 레이아웃, 데이터);
        //레이아웃 : 리스트 뷰에 보여질 아이템 뷰
        //데이터 : 마이템 뷰에 출력할 데이터
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                list
        );

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //adapterView 는 클릭이 일어난 AdapterView
            //view : 클릭한 아이템 뷰를 view 객체로 반환
            // i,j는 사용자가 클릭햇을 뷰 인덱스를 반환

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = list.get(i);
                Toast.makeText(getActivity(),"선택한 항목 : "+data,Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"롱클릭",Toast.LENGTH_SHORT).show();
                String dat = list.get(i);
                adapter.remove(dat);

                return false;
            }
        });
        //버튼 클릭 시 ListView에 저장
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtdata = edtData.getText().toString();
                adapter.add(edtdata);
                //list.add(edtdata);
                //adapter.notifyDataSetChanged();
                edtData.setText("");
            }
        });
        return view;
    }
}


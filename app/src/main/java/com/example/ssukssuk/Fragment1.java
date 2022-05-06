package com.example.ssukssuk;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.List;


public class Fragment1 extends Fragment {
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    EditText edtData;
    Button btn_register;
    private ArrayList<String> list2;          // 데이터를 넣은 리스트변수
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        MainActivity activity = (MainActivity) getActivity();

        edtData = view.findViewById(R.id.edt);
        btn_register = view.findViewById(R.id.btn_register);
        list2 = new ArrayList<String>();

        lv = view.findViewById(R.id.lv);
        list = new ArrayList<String>();
        list.add("abc");
        list.add("인클라인 벤치프레스");
        list.add("시티드 로우");
        list.add("데드리프트");
        list.add("adad");
        list.add("덤벨 프레스");
        list.add("레그 프레스");
        list.add("fff");
        list.add("ccchh");
        list.add("프로틴");
        list.add("단백질");
        list.add("스테로이드");
        list2.addAll(list);
        //new ArrayAdapter<String>(현재 액티비티명.this, 레이아웃, 데이터);
        //레이아웃 : 리스트 뷰에 보여질 아이템 뷰
        //데이터 : 마이템 뷰에 출력할 데이터
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                list
        );

        lv.setAdapter(adapter);
        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = edtData.getText().toString();
                search(text);
            }
        });


        // 검색을 수행하는 메소드

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //adapterView 는 클릭이 일어난 AdapterView
            //view : 클릭한 아이템 뷰를 view 객체로 반환
            // i,j는 사용자가 클릭햇을 뷰 인덱스를 반환

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = list.get(i);
                Toast.makeText(getActivity(), "선택한 항목 : " + data, Toast.LENGTH_SHORT).show();
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
    public void search(String charText) {

    // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
    list.clear();

    // 문자 입력이 없을때는 모든 데이터를 보여준다.
    if (charText.length() == 0) {
        list.addAll(list2);
    }
    // 문자 입력을 할때..
    else {
        // 리스트의 모든 데이터를 검색한다.
        for (int i = 0; i < list2.size(); i++) {
            // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
            if (list2.get(i).toLowerCase().contains(charText)) {
                // 검색된 데이터를 리스트에 추가한다.
                list.add(list2.get(i));
            }
        }
    }
    // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
    adapter.notifyDataSetChanged();
    }
}


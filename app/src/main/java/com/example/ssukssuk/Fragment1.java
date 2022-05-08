package com.example.ssukssuk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ssukssuk.Board.BoardAdapter;
import com.example.ssukssuk.Board.BoardVO;

import java.util.ArrayList;


public class Fragment1 extends Fragment {
    ListView lv;
    BoardAdapter adapter;
    ArrayList<BoardVO> list;
    EditText edtData;
    Button btn_register;
    ArrayList<BoardVO> list2;          // 데이터를 넣은 리스트변수
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        edtData = view.findViewById(R.id.edt);
        btn_register = view.findViewById(R.id.btn_register);
        list2 = new ArrayList<BoardVO>();
        lv = view.findViewById(R.id.lv);
        list = new ArrayList<BoardVO>();

        for(int i =0; i<11; i++){
            String writer = "dfdfd"+i;
            String title ="dfdfd";
            String date = "dfdfddffff";
            list.add(new BoardVO(writer,title,date));
            list2.add(new BoardVO(writer,title,date));
        }




        //new ArrayAdapter<String>(현재 액티비티명.this, 레이아웃, 데이터);
        //레이아웃 : 리스트 뷰에 보여질 아이템 뷰
        //데이터 : 마이템 뷰에 출력할 데이터
        adapter = new BoardAdapter(
                getActivity(),
                R.layout.board_list,
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Board_write.class);
                intent.putExtra("title",list.get(i).getTitle());
                startActivity(intent);

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
            if (list2.get(i).toString().contains(charText)) {
                // 검색된 데이터를 리스트에 추가한다.
                list.add(list2.get(i));
            }
        }
    }
    // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
    adapter.notifyDataSetChanged();
    }
}


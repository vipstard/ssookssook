package com.example.ssukssuk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    ListView lvProduct;
    BoardAdapter adapter;
    ArrayList<BoardVO> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        lvProduct = view.findViewById(R.id.list_user);
        list = new ArrayList<BoardVO>();
        //리스트 ID를 동적으로 접근하는 방법

        for(int i =0; i<11; i++){

            int imgId = getResources().getIdentifier("item"+(i+1), "drawable","com.example.ssukssuk");
            String strId = String.valueOf(getResources().getIdentifier("item"+(i+13), "string","com.example.ssukssuk"));
            String date = String.valueOf(getResources().getIdentifier("item"+(i+11), "string","com.example.ssukssuk"));
            list.add(new BoardVO(imgId,strId,date));

        }

        adapter = new BoardAdapter(
                getActivity(),
                R.layout.board_list,
                list);
        lvProduct.setAdapter(adapter);
return view;
    }
}
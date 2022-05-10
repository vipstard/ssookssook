package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ssukssuk.ServiceCenter.ServiceAdapter;
import com.example.ssukssuk.ServiceCenter.ServiceVO;
import com.example.ssukssuk.Diary.DiaryAdapter;
import com.example.ssukssuk.Diary.DiaryVO;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    ListView lv;
    ServiceAdapter adapter;
    ArrayList<ServiceVO> list;
    Button btn_write;
    TextView number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        btn_write = view.findViewById(R.id.btn_SC_Write);
        lv = view.findViewById(R.id.list_SC_post);
        list = new ArrayList<ServiceVO>();
        number = view.findViewById(R.id.sclist_number);

        for(int i =0; i<11; i++) {

            String title = "5151515";
            String date = "5151515166656";
            String writer = "81818555555555555";
            list.add(new ServiceVO(title, date,writer));
        }

        adapter = new ServiceAdapter(getActivity(),R.layout.servicecenter_list,list);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),DiaryActivity2.class);
                intent.putExtra("SCwriter",list.get(i).getWriter());
                intent.putExtra("SCtitle",list.get(i).getTitle());
                intent.putExtra("SCdate",list.get(i).getDate());
                startActivity(intent);
            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TestSuccess.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
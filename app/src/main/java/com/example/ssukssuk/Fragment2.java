package com.example.ssukssuk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.ssukssuk.Diary.DiaryAdapter;
import com.example.ssukssuk.Diary.DiaryVO;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    ListView lvUser;
    DiaryAdapter adapter;
    ArrayList<DiaryVO> list;
    Button btn_pic, btn_gall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        lvUser = view.findViewById(R.id.list_user);
        list = new ArrayList<DiaryVO>();
        //리스트 ID를 동적으로 접근하는 방법
        btn_gall = view.findViewById(R.id.btn_D_Write);
        btn_pic = view.findViewById(R.id.btn_D_Picture);
       
        btn_gall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Diary_write.class);
                startActivity(intent);
            }
        });
        for (int i = 0; i < 11; i++) {

            int imgId = getResources().getIdentifier("item" + (i + 1), "drawable", "com.example.ssukssuk");
            String title = String.valueOf(getResources().getIdentifier("item" + (i + 1), "string", "com.example.ssukssuk"));
            String date = String.valueOf(getResources().getIdentifier("date" + (i + 11), "string", "com.example.ssukssuk"));
            list.add(new DiaryVO(imgId, title, date));

        }

        adapter = new DiaryAdapter(
                getActivity(),
                R.layout.diary_list,
                list);
        lvUser.setAdapter(adapter);
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DiaryActivity2.class);
                intent.putExtra("img", list.get(i).getImg());
                intent.putExtra("title", list.get(i).getTitle());
                intent.putExtra("date", list.get(i).getDate());
                startActivity(intent);
            }
        });
        return view;
    }
}
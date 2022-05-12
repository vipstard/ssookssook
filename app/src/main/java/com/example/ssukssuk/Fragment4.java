package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.ServiceCenter.ScWriteActivity;
import com.example.ssukssuk.ServiceCenter.ServiceAdapter;
import com.example.ssukssuk.ServiceCenter.ServiceVO;
import com.example.ssukssuk.Diary.DiaryAdapter;
import com.example.ssukssuk.Diary.DiaryVO;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    ListView lv;
    ServiceAdapter adapter;
    ArrayList<ServiceVO> list;
    Button btn_write;
    TextView number;
    String title = "";
    String date = "";
    String writer = "";


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        btn_write = view.findViewById(R.id.btn_SC_Write);
        lv = view.findViewById(R.id.list_SC_post);
        list = new ArrayList<ServiceVO>();
        number = view.findViewById(R.id.sclist_number);
//
//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                int a = 1;
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                } else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                    DataSnapshot snapshot = task.getResult();
//
//                    for (DataSnapshot data : snapshot.getChildren()) {
//                        a++;
//                        BoardVO_content vo = data.getValue(BoardVO_content.class);
//                        writer = vo.getWriter();
//                        title = vo.getTitle();
//                        date = vo.getDate();
////                        if(writer.equals())
//                        list.add(new ServiceVO(a,title,date));
//                        adapter.notifyDataSetChanged();
//                        Toast.makeText(getActivity(),writer,Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }
//        });
//
//
//
//        adapter = new ServiceAdapter(
//                getActivity(),
//                R.layout.listcustomer,
//                list
//        );

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
                Intent intent = new Intent(getActivity(), ScWriteActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
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

import com.example.ssukssuk.ServiceCenter.ScAdapter;
import com.example.ssukssuk.ServiceCenter.ScVO;
import com.example.ssukssuk.ServiceCenter.ScWriteActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    ListView lv;
    ScAdapter adapter;
    ArrayList<ScVO> list;
    Button btn_write;
    TextView number;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ServiceCenter");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        btn_write = view.findViewById(R.id.btn_SC_Write);
        lv = view.findViewById(R.id.list_SC);
        list = new ArrayList<ScVO>();
        number = view.findViewById(R.id.sclist_number);

        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                int a = 0;

                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();

                    for (DataSnapshot data : snapshot.getChildren()) {

                        ScVO vo = data.getValue(ScVO.class);
                        //여기까지가 데이터 불러오기

                        String writer = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                                getString("user_login_id1",null);

                        if(writer.equals(vo.getWriter())){
                            a++;
                            String num = String.valueOf(a);

                            String title = vo.getTitle();
                            String date = vo.getDate();
                            list.add(new ScVO(num,title, date));
                            adapter.notifyDataSetChanged();
                        }

                    }

                }
            }
        });



        adapter = new ScAdapter(
                getActivity(),
                R.layout.sc_list,
                list
        );

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
package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.ssukssuk.ServiceCenter.ScEditActivity;
import com.example.ssukssuk.ServiceCenter.ScListViewActivity;
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
        String writer = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);

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


                        //로그인한 아이디와 글쓴 작성자의 값이 같으면
                        if (writer.equals(vo.getWriter())) {

                            //게시글 번호 매기기
                            a++;
                            String num = String.valueOf(a);

                            String title = vo.getTitle();
                            String date = vo.getDate();
                            //파이어베이스의 값을 삽입해서 리스트에 넣어준다
                            list.add(new ScVO(num, title, date));
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

                //클릭한 리스트뷰의 값을 해당 게시글에 값을 보내주록 저장하는 기능
                Intent intent = new Intent(getActivity(), ScListViewActivity.class);
                intent.putExtra("SCwriter", list.get(i).getWriter());
                intent.putExtra("SCtitle", list.get(i).getTitle());
                intent.putExtra("SCdate", list.get(i).getDate());
                //이동
                startActivity(intent);
            }
        });

        //글 작성 페이지 이동
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ScWriteActivity.class));
            }
        });

        return view;

    }
}
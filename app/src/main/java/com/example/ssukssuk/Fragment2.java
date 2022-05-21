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

import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.Diary.DiaryVO;
import com.example.ssukssuk.ServiceCenter.VO.ScAdapter;
import com.example.ssukssuk.ServiceCenter.VO.ScVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    ListView lv;
    ScAdapter adapter;
    ArrayList<ScVO> list;
    Button btn_write,btn_all;
    TextView number;
    String date;
    String content;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");
    String title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        lv = view.findViewById(R.id.list_user);
        btn_all = view.findViewById(R.id.btn_D_Picture);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        String pot_name = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("pot_name", null);
        list = new ArrayList<ScVO>();
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

                        BoardVO vo = data.getValue(BoardVO.class);
                        if(pot_name.equals(vo.getPot_name())){
                        //여기까지가 데이터 불러오기
                        if (writer.equals(vo.getWriter())) {
                            //게시글 번호 매기기
                            a++;
                            String num = String.valueOf(a);
                            title = vo.getTitle();
                            date = vo.getDate();
                            content = vo.getContent();
                            //파이어베이스의 값을 삽입해서 리스트에 넣어준다
                            list.add(new ScVO(num, title, date));
                            adapter.notifyDataSetChanged();
                        }
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
                Intent intent = new Intent(getActivity(), DiaryActivity2.class);
                String title = list.get(i).getTitle();
                String writer = list.get(i).getWriter();
                String sel_date =  list.get(i).getDate();

                //누른 게시글의 제목,글쓴사람,날짜를 저장한다
                SharedPreferences spf = getActivity().
                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putString("Diary_select_title", title);
                editor.putString("Diary_select_writer",writer);
                editor.putString("Diary_select_date",sel_date);
                editor.putString("Diary_select_content",content);

                editor.commit();

                startActivity(intent);

            }
        });
        btn_write = view.findViewById(R.id.btn_D_Write);
        //글 작성 페이지 이동
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Diary_write.class));
            }
        });
        return view;
    }
}
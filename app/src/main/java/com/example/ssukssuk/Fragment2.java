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
    ListView lv;
    ScAdapter adapter;
    ArrayList<ScVO> list;
    Button btn_write,btn_reg;
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

        list = new ArrayList<ScVO>();
        String writer = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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

                        BoardVO vo = data.getValue(BoardVO.class);
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

        adapter = new DiaryAdapter(
                getActivity(),
                R.layout.diary_list,
                list);
        lvUser.setAdapter(adapter);
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DiaryActivity2.class);
                String title = list.get(i).getTitle();
//                String writer = list.get(i).getWriter();
                String sel_date =  list.get(i).getDate();

                //누른 게시글의 제목,글쓴사람,날짜를 저장한다
                SharedPreferences spf = getActivity().
                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putString("Diary_select_title", title);
//                editor.putString("Diary_select_writer",writer);
                editor.putString("Diary_select_date",sel_date);
//                editor.putString("Diary_select_content",content);

                Log.d("add",title);
                Log.d("add2",sel_date);

                editor.commit();

                startActivity(intent);
            }
        });
        return view;
    }
}
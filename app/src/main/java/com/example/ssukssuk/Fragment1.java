package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ssukssuk.Board.BoardAdapter;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class Fragment1 extends Fragment {
    ListView lv;
    BoardAdapter adapter;
    ArrayList<BoardVO> list;
    EditText edtData;
    Button btn_register;
    ArrayList<BoardVO> list2;          // 데이터를 넣은 리스트변수
    String title = "";
    String date = "";
    String writer = "";
    final int i = 0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Board");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);


        String loginId = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id1", null);
        edtData = view.findViewById(R.id.edt_B_Search);
        btn_register = view.findViewById(R.id.btn_BF_Write);
        list2 = new ArrayList<BoardVO>();
        lv = view.findViewById(R.id.lv);
        list = new ArrayList<BoardVO>();

        //등록하기 버튼
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Board_write.class);
                intent.putExtra("id", loginId);
                startActivity(intent);
            }
        });

        //게시판 리스트 띄우기
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot snapshot = task.getResult();

                    for (DataSnapshot data : snapshot.getChildren()) {

                        BoardVO_content vo = data.getValue(BoardVO_content.class);
                        writer = vo.getWriter();
                        title = vo.getTitle();
                        date = vo.getDate();
                        list.add(new BoardVO(writer, title, date));
                        list2.add(new BoardVO(writer, title, date));
                        adapter.notifyDataSetChanged();
                    }

                }
            }
        });


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

        //리스트 항목 누를 시 실행
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Board_list_select.class);
                String title = list.get(i).getTitle();

                SharedPreferences spf = getActivity().
                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putString("title", title);
                editor.putString("writer", writer);
                editor.commit();

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


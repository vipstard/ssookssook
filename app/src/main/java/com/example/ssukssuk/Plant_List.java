package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Plant_List extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
//        lv = findViewById(R.id.Plant_list_Listview);
//        list = new ArrayList<PlantVO>();
//        number = view.findViewById(R.id.sclist_number);
//
//        for(int i =0; i<11; i++) {
//
//            String title = "5151515";
//            String date = "5151515166656";
//            String writer = "81818555555555555";
//            list.add(new ScVO(title, date,writer));
//        }
//
//        adapter = new ScAdapter(getActivity(),R.layout.servicecenter_list,list);
//
//        lv.setAdapter(adapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(),DiaryActivity2.class);
//                intent.putExtra("SCwriter",list.get(i).getWriter());
//                intent.putExtra("SCtitle",list.get(i).getTitle());
//                intent.putExtra("SCdate",list.get(i).getDate());
//                startActivity(intent);
//            }
//        });
    }
}
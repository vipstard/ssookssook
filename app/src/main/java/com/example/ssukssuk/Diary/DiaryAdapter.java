package com.example.ssukssuk.Diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;

public class DiaryAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<DiaryVO> list;
    LayoutInflater inflater;
    public DiaryAdapter(Context context, int item_layout, ArrayList<DiaryVO> list) {
        this.context = context;
        this.item_layout = item_layout;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    //선택한 인덱스의 내용물?
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    //선택한 인덱스를 반환하는 부분
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        DiaryHolder holder = null;

        if(view ==null){
            view = inflater.inflate(item_layout, viewGroup, false);
            holder = new DiaryHolder(view);

            view.setTag(holder);
        }else{
            holder = (DiaryHolder) view.getTag();
        }
        DiaryVO vo = (DiaryVO) getItem(i);

        holder.getImg().setImageResource(vo.getImg());
        holder.getTitle().setText(vo.getTitle());
        holder.getDate().setText(vo.getDate());

        return view; //젤 중요
    }
}

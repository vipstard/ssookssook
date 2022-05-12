package com.example.ssukssuk.Plant_reg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;

public class PlantAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<Reg_Plant_mainVO> list;
    LayoutInflater inflater;
    public PlantAdapter(Context context, int item_layout, ArrayList<Reg_Plant_mainVO> list) {
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

        PlantHolder holder = null;

        if(view ==null){
            view = inflater.inflate(item_layout, viewGroup, false);
            holder = new PlantHolder(view);

            view.setTag(holder);
        }else{
            holder = (PlantHolder) view.getTag();
        }
        Reg_Plant_mainVO vo = (Reg_Plant_mainVO) getItem(i);


        holder.getName().setText(vo.getPot_name());
        holder.getDate().setText(vo.getDate());


        return view; //젤 중요
    }
}
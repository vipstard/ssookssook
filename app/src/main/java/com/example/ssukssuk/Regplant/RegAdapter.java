package com.example.ssukssuk.Regplant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ssukssuk.Board.BoardHolder;
import com.example.ssukssuk.Board.BoardVO;

import java.util.ArrayList;

public class RegAdapter {
    Context context;
    int item_layout;
    ArrayList<RegVO> list;
    LayoutInflater inflater;
    public RegAdapter(Context context, int item_layout, ArrayList<RegVO> list) {
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

        RegHolder holder = null;

        if(view ==null){
            view = inflater.inflate(item_layout, viewGroup, false);
            holder = new RegHolder(view);

            view.setTag(holder);
        }else{
            holder = (RegHolder) view.getTag();
        }
        RegVO vo = (RegVO) getItem(i);



        holder.getName().setText(vo.getname());
        holder.getType().setText(vo.gettype());

        return view; //젤 중요
    }
}

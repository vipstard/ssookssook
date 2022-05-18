package com.example.ssukssuk.ServiceCenter.VO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ScAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ScVO> list;
    LayoutInflater inflater;


    public ScAdapter(Context context, int layout, ArrayList<ScVO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); ;
    }

//    public ScAdapter(FragmentActivity activity, int servicecenter_list, ArrayList<ScVO> list) {
//    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ScHolder holder = null;

        if(view ==null){
            view = inflater.inflate(layout, viewGroup, false);
            holder = new ScHolder(view);
            view.setTag(holder);
        }else{
            holder = (ScHolder) view.getTag();
        }
        ScVO vo = (ScVO) getItem(i);

        holder.getTitle().setText(vo.getTitle());
        holder.getDate().setText(vo.getDate());
        holder.getNum().setText(vo.getNum());

        return view;
    }
}
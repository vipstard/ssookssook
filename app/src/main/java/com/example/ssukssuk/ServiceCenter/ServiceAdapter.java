package com.example.ssukssuk.ServiceCenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.FragmentActivity;

import com.example.ssukssuk.Board.BoardHolder;
import com.example.ssukssuk.Board.BoardVO;

import java.util.ArrayList;

public class ServiceAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ServiceVO> list;
    LayoutInflater inflater;


    public ServiceAdapter(Context context, int layout, ArrayList<ServiceVO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); ;
    }

//    public ServiceAdapter(FragmentActivity activity, int servicecenter_list, ArrayList<ServiceVO> list) {
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

        ServiceHolder holder = null;

        if(view ==null){
            view = inflater.inflate(layout, viewGroup, false);
            holder = new ServiceHolder(view);
            view.setTag(holder);
        }else{
            holder = (ServiceHolder) view.getTag();
        }
        ServiceVO vo = (ServiceVO) getItem(i);

        holder.getTitle().setText(vo.getTitle());
        holder.getDate().setText(vo.getDate());
        holder.getWriter().setText(vo.getWriter());

        return view;
    }
}

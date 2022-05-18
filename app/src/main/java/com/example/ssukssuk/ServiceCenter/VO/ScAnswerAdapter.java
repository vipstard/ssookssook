package com.example.ssukssuk.ServiceCenter.VO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ssukssuk.Board_answerVO.Board_answer_Holder;
import com.example.ssukssuk.VO.Board_list_select_writeVO;

import java.util.ArrayList;

public class ScAnswerAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<Board_list_select_writeVO> list;
    LayoutInflater inflater;
    public ScAnswerAdapter(Context context, int item_layout, ArrayList<Board_list_select_writeVO> list) {
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

        ScAnswerHolder holder = null;

        if(view ==null){
            view = inflater.inflate(item_layout, viewGroup, false);
            holder = new ScAnswerHolder(view);

            view.setTag(holder);
        }else{
            holder = (ScAnswerHolder) view.getTag();
        }
        ScVO vo = (ScVO) getItem(i);



        holder.getDate().setText(vo.getDate());
        holder.getContent().setText(vo.getContent());
        holder.getWriter().setText(vo.getWriter());

        return view; //젤 중요
    }
}
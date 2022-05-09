package com.example.ssukssuk.Regplant;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.ssukssuk.Board.BoardHolder;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.R;
import com.example.ssukssuk.Reg_Plant_main;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RegAdapter extends BaseAdapter {
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
        final TextView text_name  = view.findViewById(R.id.reg_r_name);
        final ListView lv = view.findViewById(R.id.reg_list);
        RegVO vo = (RegVO) getItem(i);

        holder.getName().setText(vo.getName());
        holder.getType().setText(vo.getType());
        text_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(context,"dd",Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자 : AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("삭제 하기").setMessage("삭제하시겠습니까? ").setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(i);
                    }
                })
                  .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                Toast.makeText(context,vo.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view; //젤 중요
    }
}

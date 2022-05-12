package com.example.ssukssuk.ServiceCenter;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;


public class ScHolder {
    private TextView title, date, num;

    public ScHolder(View itemView){
        title = itemView.findViewById(R.id.sclist_title);
        date = itemView.findViewById(R.id.sclist_date);
        num = itemView.findViewById(R.id.sclist_number);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getNum() {
        return num;
    }
}

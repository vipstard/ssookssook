package com.example.ssukssuk.ServiceCenter;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;


public class ServiceHolder {
    private TextView title, date, writer;

    public ServiceHolder(View itemView){

        title = itemView.findViewById(R.id.sclist_title);
        date = itemView.findViewById(R.id.sclist_date);
        writer = itemView.findViewById(R.id.sclist_writer);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getWriter() {
        return writer;
    }
}

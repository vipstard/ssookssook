package com.example.ssukssuk.ServiceCenter.VO;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class ScAnswerHolder {
    private TextView content, date, writer;

    public ScAnswerHolder(View itemView) {
        date = itemView.findViewById(R.id.answer_date2);
        content = itemView.findViewById(R.id.answer_content2);
        writer = itemView.findViewById(R.id.answer_writer2);

    }

    public TextView getContent() {
        return content;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getWriter() {
        return writer;
    }
}
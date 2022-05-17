package com.example.ssukssuk.ServiceCenter.VO;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class ScAnswerHolder {
    private TextView content, date, writer;

    public ScAnswerHolder(View itemView) {
        date = itemView.findViewById(R.id.answer_date);
        content = itemView.findViewById(R.id.answer_content);
        writer = itemView.findViewById(R.id.answer_writer);

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
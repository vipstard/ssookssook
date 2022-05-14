package com.example.ssukssuk.Board_answerVO;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class Board_answer_Holder {
    private TextView content, date, writer;

    public Board_answer_Holder(View itemView) {
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

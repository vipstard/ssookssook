package com.example.ssukssuk.Board;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class BoardHolder {
    private TextView title, date, writer;

    public BoardHolder(View itemView) {
        title = itemView.findViewById(R.id.board_title);
        date = itemView.findViewById(R.id.board_date);
        writer = itemView.findViewById(R.id.board_writer);

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



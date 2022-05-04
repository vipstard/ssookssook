package com.example.ssukssuk;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BoardHolder { private TextView pro_name;
    private TextView title,date;
    private ImageView img;


    public BoardHolder(View itemView){
        img = itemView.findViewById(R.id.img);
        title = itemView.findViewById(R.id.board_title);
        date = itemView.findViewById(R.id.board_date);

    }

    public ImageView getImg() { return img; }

    public TextView getTitle() {
        return title;
    }

    public TextView getDate() {
        return date;
    }


}


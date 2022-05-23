package com.example.ssukssuk.Diary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class DiaryHolder {
    private TextView title,date;
    private ImageView img;


    public DiaryHolder(View itemView){
        img = itemView.findViewById(R.id.img);
        title = itemView.findViewById(R.id.btn_DLSA_Title);
        date = itemView.findViewById(R.id.diary_date);

    }

    public ImageView getImg() { return img; }

    public TextView getTitle() {
        return title;
    }

    public TextView getDate() {
        return date;
    }


}


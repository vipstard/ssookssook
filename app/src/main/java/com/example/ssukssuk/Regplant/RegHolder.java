package com.example.ssukssuk.Regplant;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class RegHolder {
    private TextView type, name;
    //private CheckBox reg_ck;
    public RegHolder(View itemView) {
        type = itemView.findViewById(R.id.reg_r_type);
        name = itemView.findViewById(R.id.reg_r_name);
      //  reg_ck = itemView.findViewById(R.id.reg_check);
    }

    public TextView getType() {
        return type;
    }

    public TextView getName() {
        return name;
    }


}

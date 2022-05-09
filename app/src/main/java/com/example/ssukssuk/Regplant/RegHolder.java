package com.example.ssukssuk.Regplant;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class RegHolder {
    private TextView type, name;
    Button btn_delete;
    //private CheckBox reg_ck;
    public RegHolder(View itemView) {
        type = itemView.findViewById(R.id.reg_r_type);
        name = itemView.findViewById(R.id.reg_r_name);
        btn_delete = itemView.findViewById(R.id.reg_plant_del);
      //  reg_ck = itemView.findViewById(R.id.reg_check);
    }

    public TextView getType() {
        return type;
    }

    public TextView getName() {
        return name;
    }


}

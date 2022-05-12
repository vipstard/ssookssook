package com.example.ssukssuk.Plant_reg;

import android.view.View;
import android.widget.TextView;

import com.example.ssukssuk.R;

public class PlantHolder {
    private TextView name, date;

    public PlantHolder(View itemView) {
        name = itemView.findViewById(R.id.pot_name);
        date = itemView.findViewById(R.id.pot_date);
    }

    public TextView getName() {
        return name;
    }

    public TextView getDate() {
        return date;
    }

}



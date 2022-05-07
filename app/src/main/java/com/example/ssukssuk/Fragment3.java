package com.example.ssukssuk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment3 extends Fragment {
    ImageView plant_img,water_img;
    ImageButton btn_water;
    Switch led_switch;
    TextView tv_led,tv_water;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);
        plant_img = view.findViewById(R.id.main_plant);
        water_img = view.findViewById(R.id.main_water);
        led_switch = view.findViewById(R.id.led_sw);
        btn_water = view.findViewById(R.id.main_water_btn);
        tv_led = view.findViewById(R.id.main_led);
        tv_water = view.findViewById(R.id.main_water_per);

        led_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    tv_led.setText("조명 켜기");
                }else{
                  tv_led.setText("조명 끄기");
                }
            }
        });
        btn_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"dfdfdf",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
package com.example.ssukssuk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.VO.BoardVO_content;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Fragment3 extends Fragment {
    ImageView plant_img,water_img;
    ImageButton btn_water;
    Switch led_switch;
    TextView tv_led,tv_water;
    RequestQueue queue;
    StringRequest request;
    int pump = 3;
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
        queue = Volley.newRequestQueue(getActivity());
        pumpeThread pum;
        led_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    tv_led.setText("조명 켜기");
                    int method = Request.Method.GET;
                    String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input1=1";
                    request = new StringRequest(
                            method,
                            server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(getActivity(),
                                            "로그인 성공"+response,
                                            Toast.LENGTH_SHORT).show();

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(),
                                            "로그인 실패"+error.toString(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                    );

                    queue.add(request);

                }else{
                  tv_led.setText("조명 끄기");
                    int method = Request.Method.POST;
                    String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input1=0";
                    request = new StringRequest(
                            method,
                            server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(getActivity(),
                                            "조작"+response,
                                            Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(),
                                            "로그인 실패"+error.toString(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                    queue.add(request);

                }
            }
        });
        btn_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pumpeThread thread = new pumpeThread();
                thread.start();// Thread 동작시키는
            }
        });
        return view;
    }
    class pumpeThread extends Thread {
        pumpeHandler handler = new pumpeHandler();
        @Override
        public void run() {
            //실행할 로직 정의
            for (int i = 0; i < 2; i++) {

                //Handler에 값을 전달 -> Message 객체
                Message msg = new Message();
                msg.arg1 = i;

                handler.sendMessage(msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//Rmx
    class pumpeHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {

            //sub Thread에서 처리한 결과를 UI에 업데이트할 때
            //handlerMessage() 안에 정의
            int count = msg.arg1;
            if(count == 0){
                int method = Request.Method.GET;
                String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input3=4";
                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(),
                                        "로그인 성공"+response,
                                        Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(),
                                        "로그인 실패"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                queue.add(request);
            }else{
                int method = Request.Method.GET;
                String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input3=3";
                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(),
                                        "로그인 성공"+response,
                                        Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(),
                                        "로그인 실패"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                queue.add(request);
            }

        }
    }
}
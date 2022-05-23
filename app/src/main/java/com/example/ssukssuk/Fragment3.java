package com.example.ssukssuk;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Fragment3 extends Fragment {
    ImageView plant_img, water_img;
    Button btn_water;
    ImageButton btn_led;
    Switch led_switch;
    TextView tv_led, tv_water, tv_text;
    RequestQueue queue;
    StringRequest request;
    String water_percent = "";
    int pump = 3;
    String rank;
    String wa = "";
    boolean a = false;
    private final String DEFAULT = "DEFAULT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);
        plant_img = view.findViewById(R.id.main_plant);
        water_img = view.findViewById(R.id.main_water);
        btn_water = view.findViewById(R.id.main_water_btn);
//        tv_led = view.findViewById(R.id.led_sw);
        tv_water = view.findViewById(R.id.main_water_per);
        btn_led = view.findViewById(R.id.btn_main_led);

        tv_text = view.findViewById(R.id.textView8);

        queue = Volley.newRequestQueue(getActivity());
        pumpeThread pum;

        btn_led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a == true) {
                    btn_led.setImageResource(R.drawable.on);
                    int method = Request.Method.GET;
                    String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input1=1";
                    request = new StringRequest(
                            method,
                            server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//                                    Toast.makeText(getActivity(),
//                                            "로그인 성공"+response,
//                                            Toast.LENGTH_SHORT).show();

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//                                    Toast.makeText(getActivity(),
//                                            "로그인 실패"+error.toString(),
//                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                    );

                    queue.add(request);
                    a = false;

                } else {
                    btn_led.setImageResource(R.drawable.off);
                    int method = Request.Method.GET;
                    String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input1=0";
                    request = new StringRequest(
                            method,
                            server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//                                    Toast.makeText(getActivity(),
//                                            "조작"+response,
//                                            Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//                                    Toast.makeText(getActivity(),
//                                            "로그인 실패"+error.toString(),
//                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                    queue.add(request);
                    a = true;

                }
            }
        });
        String URL = "http://211.227.224.199:8081/SS/And_Ardu3";
        request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONArray result = obj.getJSONArray("data");

//                            JSONArray jsonArray = result.getJSONArray("soil");

                            String data = "";
//                            StringBuffer sb = new StringBuffer();


                            for (int i = 0; i < result.length(); i++) {
                                JSONObject soil = result.getJSONObject(i);
                                data = soil.getString("soil");
                                wa = soil.getString("water");
                                Log.d("soil", data);
//
//                                water_percent = soil.getString("soil");
//                                System.out.println("water_percent="+water_percent);
//                                System.out.println("soil = "+ soil);
                            }
                            tv_text.setText(data + "%");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }
        );//서버에서 받기
        queue.add(request);
        //알림 기능 구현

        if (wa.equals("0")) {
            tv_water.setText("0%");
            water_img.setImageResource(R.drawable.water0);

        }
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
            if (count == 0) {
                int method = Request.Method.GET;
                String server_url = "http://211.227.224.199:8081/SS/And_Ardvu2?input3=4";
                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//                                Toast.makeText(getActivity(),
//                                        "로그인 성공"+response,
//                                        Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//                                Toast.makeText(getActivity(),
//                                        "로그인 실패"+error.toString(),
//                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                queue.add(request);
            } else {
                String a = "";
                int method = Request.Method.GET;
                String server_url = "http://211.227.224.199:8081/SS/And_Ardu2?input3=3";
                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//                                Toast.makeText(getActivity(),
//                                        "로그인 성공"+response,
//                                        Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//                                Toast.makeText(getActivity(),
//                                        "로그인 실패"+error.toString(),
//                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                queue.add(request);
            }

        }
    }
//    void createNOtification1(String channId, int id, String title, String text, Intent intent){
//        Resources res = getResources();
//        Intent notificationIntent = new Intent(getActivity(),MainActivity.class);
//        notificationIntent.putExtra("noti_Id",9999);
//
//        PendingIntent contentIntent = PendingIntent.getActivity(getActivity(),0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
//        builder.setContentTitle("물 부족!")
//                .setContentText("물통의 물이 부족합니다.")
//                .setSmallIcon(R.drawable.water0)
//                .setContentIntent(contentIntent)
//                .setAutoCancel(true)
//                .setWhen(System.currentTimeMillis())
//                .setDefaults(Notification.DEFAULT_ALL);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            builder.setCategory(Notification.CATEGORY_MESSAGE)
//                    .setPriority(Notification.PRIORITY_HIGH)
//                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
//        }
//        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        nm.notify(1234,builder.build());
//
//
//        }



}

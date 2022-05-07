package com.example.ssukssuk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        String id = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("user_login_id","df");
        tv = view.findViewById(R.id.test2222);
        tv.setText(id);


        return view;

    }
}
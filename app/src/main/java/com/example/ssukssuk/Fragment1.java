package com.example.ssukssuk;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Fragment1 extends Fragment {
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        webView = view.findViewById(R.id.webView);

        //SharedPreferences에 저장된 데이터 접근
        String url = getActivity().
                getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                getString("url","https://www.smhrd.or.kr");


        // 안드로이드에 설치되어 있는 기본 브라우저 실행
        // --> WebSettings 객체를 이용해서 Webview에 바로 띄워지도록 설정
        WebSettings settings = webView.getSettings();

        //자바스크립트 사용 허용
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url );
        return view;
    }
}
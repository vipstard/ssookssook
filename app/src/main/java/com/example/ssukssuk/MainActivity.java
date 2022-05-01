package com.example.ssukssuk;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    Fragment1 frag_home;
    Fragment2 frag_time;
    Fragment3 frag_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        frag_home = new Fragment1();
        frag_time = new Fragment2();
        frag_option = new Fragment3();

        //실행 시 처음 보여줄 프래그먼트 화면 설정
        //replace(프래그먼트를 보여주는 레이아웃 리소스 ID, 보여줄 프래그먼트객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();
        //메뉴버튼 클릭 시 화면 전환
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //선택한 메뉴버튼에 대한 리소스ID 저장
                int itemId = item.getItemId();
                if(itemId == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();
                }else if(itemId == R.id.timer){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_time).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_option).commit();
                }
                return false;
            }
        });
    }
}
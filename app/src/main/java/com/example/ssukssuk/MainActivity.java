package com.example.ssukssuk;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    Fragment1 frag_board;
    Fragment2 frag_grow;
    Fragment3 frag_main;
    Fragment4 frag_customer;
    Fragment5 frag_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        frag_board = new Fragment1();
        frag_grow = new Fragment2();
        frag_main = new Fragment3();
        frag_customer = new Fragment4();
        frag_set = new Fragment5();

        //실행 시 처음 보여줄 프래그먼트 화면 설정
        //replace(프래그먼트를 보여주는 레이아웃 리소스 ID, 보여줄 프래그먼트객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_main).commit();
        //메뉴버튼 클릭 시 화면 전환
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //선택한 메뉴버튼에 대한 리소스ID 저장
                int itemId = item.getItemId();

                if(itemId == R.id.board){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_board).commit();
                    return true;
                }else if(itemId == R.id.grow){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_grow).commit();
                    return true;

                }else if(itemId == R.id.main){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_main).commit();
                    return true;

                }else if(itemId == R.id.customer){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_customer).commit();
                    return true;

                }else if(itemId == R.id.set){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_set).commit();
                    return true;

                }
                return false;
            }
        });
    }

    //현재 페이지에서 뒤로가기 막는 기능
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
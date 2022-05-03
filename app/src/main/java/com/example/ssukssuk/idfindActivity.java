package com.example.ssukssuk;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class idfindActivity extends AppCompatActivity {

    private final int Fragment_2 = 1;
    private final int Fragment_1 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idfind);

    findViewById(R.id.btnphone).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            FragmentView(Fragment_1);

        }
    });

    findViewById(R.id.btnemail).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentView(Fragment_2);


        }
    });
    FragmentView(Fragment_1);
}

    private void FragmentView(int fragment){

        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment){
            case 1:
                // 첫번 째 프래그먼트 호출
                idFindEmailFragment fragment1 = new idFindEmailFragment();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // 두번 째 프래그먼트 호출
                idFindPhoneFragment fragment2 = new idFindPhoneFragment();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }

    }
}
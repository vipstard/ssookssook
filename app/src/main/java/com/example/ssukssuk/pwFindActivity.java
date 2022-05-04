package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class pwFindActivity extends AppCompatActivity {

    private final int pwEmailFragment = 1;
    private final int pwPhoneFragment = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwfind);



            findViewById(R.id.btnPhone).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentView(pwPhoneFragment);

                }
            });

            findViewById(R.id.btnEmail).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentView(pwEmailFragment);


                }
            });
            FragmentView(pwPhoneFragment);
        }

        private void FragmentView(int fragment){

            //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (fragment){
                case 1:
                    // 첫번 째 프래그먼트 호출
                    pwFindEmailFragment fragment1 = new pwFindEmailFragment();
                    transaction.replace(R.id.fragment_container, fragment1);
                    transaction.commit();
                    break;

                case 2:
                    // 두번 째 프래그먼트 호출
                    pwFindPhoneFragment fragment2 = new pwFindPhoneFragment();
                    transaction.replace(R.id.fragment_container, fragment2);
                    transaction.commit();
                    break;
            }

        }
    }

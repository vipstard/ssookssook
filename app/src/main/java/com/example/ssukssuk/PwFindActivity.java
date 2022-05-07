package com.example.ssukssuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PwFindActivity extends AppCompatActivity {

    Button back;

    private final int pwEmailFragment = 1;
    private final int pwPhoneFragment = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwfind);

        back = findViewById(R.id.btn_SA_Back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


            findViewById(R.id.btn_PFP_Phone).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentView(pwPhoneFragment);

                }
            });

            findViewById(R.id.btn_PFP_Email).setOnClickListener(new View.OnClickListener() {
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
                    PwFindEmailFragment fragment1 = new PwFindEmailFragment();
                    transaction.replace(R.id.fragment_container, fragment1);
                    transaction.commit();
                    break;

                case 2:
                    // 두번 째 프래그먼트 호출
                    PwFindPhoneFragment fragment2 = new PwFindPhoneFragment();
                    transaction.replace(R.id.fragment_container, fragment2);
                    transaction.commit();
                    break;
            }

        }
    }

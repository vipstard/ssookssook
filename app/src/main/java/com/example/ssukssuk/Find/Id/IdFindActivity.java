package com.example.ssukssuk.Find.Id;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ssukssuk.R;

public class IdFindActivity extends AppCompatActivity {

    Button back;
    private final int idFragment_2 = 1;
    private final int idFragment_1 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find);

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

            FragmentView(idFragment_1);

        }
    });

    findViewById(R.id.btn_PFP_Email).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentView(idFragment_2);


        }
    });
    FragmentView(idFragment_1);
}

    private void FragmentView(int fragment){

        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment){
            case 1:
                // 첫번 째 프래그먼트 호출
                IdFindEmailFragment fragment1 = new IdFindEmailFragment();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // 두번 째 프래그먼트 호출
                IdFindPhoneFragment fragment2 = new IdFindPhoneFragment();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }

    }
}
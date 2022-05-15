package com.example.ssukssuk.Find.Id;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssukssuk.R;
import com.example.ssukssuk.VO.SignVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class IdFindPhoneFragment extends Fragment {

    EditText edtPhone,edtName;
    Button btnFindId;
    int cnt = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("sign");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_id_find_phone, container, false);

        edtName= view.findViewById(R.id.edt_IFP_Name);
        edtPhone = view.findViewById(R.id.edt_IFP_Phone);
        btnFindId = view.findViewById(R.id.btn_IFP_IdFind);

        SharedPreferences spf = getActivity().
                getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();


        btnFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        } else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            DataSnapshot snapshot = task.getResult();

                            for (DataSnapshot data : snapshot.getChildren()) {

                                SignVO vo = data.getValue(SignVO.class);

                                String name = edtName.getText().toString();
                                String phone = edtPhone.getText().toString();

                                if (name.equals(vo.getName()) && phone.equals(vo.getEmail())) {
                                    editor.putString("find_id",vo.getId());
                                    editor.putString("find_name",vo.getName());
                                    editor.commit();
                                    cnt ++;
                                    break;
                                }else{
                                    cnt = 0;
                                }

                            }
                            if (cnt == 0) {
                                startActivity(new Intent(getActivity(), IdFindFailActivity.class));

                            } else {
                                startActivity(new Intent(getActivity(), IdFindSuccessActivity.class));

                            }
                        }
                    }
                });
            }
        });
        return view;
    }

}

package com.example.ssukssuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ssukssuk.Board.BoardVO;
import com.example.ssukssuk.Diary.DiaryVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Diary_pic extends AppCompatActivity {
    Button btn_photo;
    private final int GALLER_CODE = 10;
    ImageView photo;
    private FirebaseStorage storage;
    EditText title;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_pic);
        ImageView img1,img2,img3,img4;
        img1 = findViewById(R.id.diary_img_1);
        img2 = findViewById(R.id.diary_img_2);
        img3 = findViewById(R.id.diary_img_3);
        img4 = findViewById(R.id.diary_img_4);

        img1.setImageResource(R.drawable.a1);
        img2.setImageResource(R.drawable.a2);
        img3.setImageResource(R.drawable.a3);
        img4.setImageResource(R.drawable.a4);
        String date;
        ImageView img_test = findViewById(R.id.diary_img_5);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String indate = sdf.format(cal.getTime());
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://ssukssuk-af5d6.appspot.com/");
        StorageReference storageRef = storage.getReference();
        storageRef.child("images/" + indate + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //이미지 로드 성공시
                Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img_test);

            }

        });
    }
}
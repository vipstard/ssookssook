package com.example.ssukssuk;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary_write extends AppCompatActivity {
    Button btn_photo;
    ImageView iv_photo;
    private static final int REQUEST_IMAGE_CODE = 101;
    final static int TAKE_PICTURE = 1;
    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;
    final private static String TAG = "nice";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_write);

        iv_photo = findViewById(R.id.imageView3);
        btn_photo = findViewById(R.id.button5);
        storage = FirebaseStorage.getInstance();
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String indate = sdf.format(cal.getTime());

                EditText content = findViewById(R.id.editTextTextMultiLine);
//                SharedPreferences spf = Board_answer.this.
//                        getSharedPreferences("mySPF", Context.MODE_PRIVATE);
//                title = intent.getStringExtra("title");
                title = findViewById(R.id.edt_title_diary);

                String writer = Diary_write.this.getSharedPreferences("mySPF", Context.MODE_PRIVATE).
                        getString("user_login_id1", null);
    }


}

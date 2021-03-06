package com.example.ssukssuk;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {
    Animation anim_FadeIn;
    Animation anim_ball;
    Animation anim_rot;
    Animation anim_rot2;
    ConstraintLayout constraintLayout;
    ImageView lcklockImageView;
    ImageView oImageView,oImageView2;
    ImageView faceRecgnitionImageView;
    ImageView faceRecgnitionImageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        constraintLayout=findViewById(R.id.constraintLayout);
        lcklockImageView=findViewById(R.id.lock_lck);
        oImageView=findViewById(R.id.lock_o);
        oImageView2=findViewById(R.id.lock_o2);
        faceRecgnitionImageView=findViewById(R.id.faceReconition);

        faceRecgnitionImageView1=findViewById(R.id.lock_lck1);
        anim_FadeIn=AnimationUtils.loadAnimation(this,R.anim.anim_splash_fadeln);
        anim_ball=AnimationUtils.loadAnimation(this,R.anim.anim_splash_ball);
        anim_rot=AnimationUtils.loadAnimation(this,R.anim.anim_splash_rot);
        anim_rot2=AnimationUtils.loadAnimation(this,R.anim.anim_splash_dfdf);
        anim_FadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lcklockImageView.startAnimation(anim_FadeIn);
        faceRecgnitionImageView.startAnimation(anim_FadeIn);
        faceRecgnitionImageView1.startAnimation(anim_FadeIn);
        oImageView.startAnimation(anim_rot2);
        oImageView2.startAnimation(anim_rot);
    }
}
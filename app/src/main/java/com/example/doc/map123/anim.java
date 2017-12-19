package com.example.doc.map123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class anim extends AppCompatActivity {
    ImageView mAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        mAnimation = (ImageView) findViewById(R.id.anim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startPropertyAnimation();
    }

    private void startPropertyAnimation() {
        Animation fire_anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mAnimation.startAnimation(fire_anim);
        fire_anim.setAnimationListener(animationListener);
    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}

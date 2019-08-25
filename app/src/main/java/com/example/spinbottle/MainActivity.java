package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;



public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    ImageView bottle;
    boolean spinning = false;
    int lastde = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = (ImageView)findViewById(R.id.bottle);
    }

    void rotate(View v)
    {
        if ( !spinning ) {
            int randa = random.nextInt() / 10000;
            int pivotx = bottle.getWidth() / 2;
            int pivoty = bottle.getHeight() / 2;
            Animation rot = new RotateAnimation(0, randa, pivotx, pivoty);
            rot.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            rot.setDuration(1000);
            rot.setFillAfter(true);
            lastde = randa;
            bottle.startAnimation(rot);
        }

    }
}

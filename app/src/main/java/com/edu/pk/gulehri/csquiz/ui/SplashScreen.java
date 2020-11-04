package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.edu.pk.gulehri.csquiz.R;

public class SplashScreen extends AppCompatActivity {

    public static final String SHARED_PREFRENCE = "shared_Prefrence";
    public static final String SHARED_PREFRENCE_VALUE = "shared_prefrence_value_compare";
    private static final String TAG = "myTag";
    public static int flag = 0;
    private static int SPLASH_TIME_OUT = 5000;
    //Hooks
    View first, second, third, fourth, fifth, sixth;
    TextView a, slogan;
    //Animations
    Animation topAnimantion, bottomAnimation, middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Log.d(TAG, "onCreate: SplashScreen");

        //Hooks
        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);
        a = findViewById(R.id.a);
        slogan = findViewById(R.id.tagLine);

        //Animation Calls
        topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        //-----------Setting Animations to the elements of Splash Screen
        first.setAnimation(topAnimantion);
        second.setAnimation(topAnimantion);
        third.setAnimation(topAnimantion);
        fourth.setAnimation(topAnimantion);
        fifth.setAnimation(topAnimantion);
        sixth.setAnimation(topAnimantion);
        a.setAnimation(middleAnimation);
        slogan.setAnimation(bottomAnimation);


        /*SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFRENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFRENCE_VALUE, flag);
        editor.apply();
*/

        //Splash Screen Code to call new Activity after some time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Calling new Activity
                Intent intent = new Intent(SplashScreen.this, StartQuizActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: SplashScreen");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: SplashScreen");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: SplashScreen");
        finish();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: SplashScreen");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: SplashScreen");
        finish();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: SplashScreen");
        super.onDestroy();
    }
}
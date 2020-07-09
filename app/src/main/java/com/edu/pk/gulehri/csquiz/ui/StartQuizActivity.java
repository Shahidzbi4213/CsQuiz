package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edu.pk.gulehri.csquiz.R;

public class StartQuizActivity extends AppCompatActivity {

    private static final String TAG = "myTag";
    private static long backPressedTime;

    //Hooks
    View first, second, third, fourth, fifth, sixth;
    TextView slogan;
    Button startQuiz, aboutUs, exitApp;

    //Animations
    Animation topAnimation, bottomAnimation, middleAnimation;


    //flag used here to check of back button is pressed and activity in the background
    private static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_quiz);
        Log.d(TAG, "onCreate: STARTQUIZ");

        //Hooks
        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);
        startQuiz = findViewById(R.id.startquiz);
        aboutUs = findViewById(R.id.aboutUs);
        exitApp = findViewById(R.id.exit);
        slogan = findViewById(R.id.tagLine);

        //Animation Calls
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        //-----------Setting Animations to the elements of Splash Screen
        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        slogan.setAnimation(bottomAnimation);


        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LanguagesActivity.class));
                finish();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutUs.class));
                finish();
            }
        });

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {

            /*When Back Button is pressed flag value become true*/
            flag = true;
            System.exit(0);
        } else {
            Toast.makeText(this, "One more tap to exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: STARTQUIZ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: STARTQUIZ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:STARTQUIZ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: STARTQUIZ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: STARTQUIZ");
        if (flag) {
            System.exit(0);
        }
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: STARTQUIZ");
        super.onDestroy();
    }
}

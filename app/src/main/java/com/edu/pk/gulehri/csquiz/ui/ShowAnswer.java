package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.AnswerAdaptor;

public class ShowAnswer extends AppCompatActivity {

    public static boolean check;
    private static long backPressedTime;
    //flag to check if back button is pressed to finish the activity
    private static boolean flag;
    private RecyclerView mRecyclerView;
    private Toolbar toolbar;
    private String languageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        mRecyclerView = findViewById(R.id.showAnswerRecycle);

        toolbar = findViewById(R.id.myToolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolBarTitle);
        try {
            setSupportActionBar(toolbar);
            toolbar.setElevation((float) 10.00);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbarTitle.setText("Answers");
            final Drawable backArrow = getResources().getDrawable(R.drawable.back_arrow);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setBackgroundColor(getResources().getColor(R.color.toolBarAnswer));

            Intent intent = getIntent();
            languageName = intent.getStringExtra("LANG_NAME");

        } catch (NullPointerException e) {
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AnswerAdaptor());
    }

    @Override
    public void onBackPressed() {
        flag = true;
        check = true;
        //The Condition says when back button is pressed twice with in 2 seconds only thn it will send intent Category Activity
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            /*When Back Button is pressed flag value become true*/

            Intent intent = new Intent(ShowAnswer.this, Category.class);
            intent.putExtra("langName", languageName);
            startActivity(intent);
        }
        /*if back button is not pressed twice with in the 2 second the toast will appear*/
        else {
            Toast.makeText(this, "One more tap to exit", Toast.LENGTH_SHORT).show();
        }
        //this gives the current time in milliseconds.
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home/back button
            case android.R.id.home:
                Intent intent = new Intent(this, Category.class);
                intent.putExtra("langName", languageName);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (flag) {
            finish();
        }
    }
}
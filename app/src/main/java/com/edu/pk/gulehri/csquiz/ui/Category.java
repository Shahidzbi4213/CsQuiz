package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.Database.MyDbOpenHelper;
import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.LanguageAdaptor;
import com.edu.pk.gulehri.csquiz.adaptor.MyAdaptor;

public class Category extends AppCompatActivity {

    private static final String TAG = "myTag";
    private Toolbar toolbar;
    private String Language;
    private TextView mTitle;
    public static RecyclerView mRecyclerView;

    //Helper Class Variable to get reference
    private MyDbOpenHelper helper;

    //flag to check if back button is pressed to finish the activity
    private static boolean flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        toolbar = findViewById(R.id.mtoolbar);
        mTitle = toolbar.findViewById(R.id.toolBarTitle);
        mRecyclerView = findViewById(R.id.category);
        helper = new MyDbOpenHelper(this);

        try {

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            final Drawable backArrow = getResources().getDrawable(R.drawable.back_arrow);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        } catch (NullPointerException e) {
        }

        //getting the intent from adaptor
        Intent intent = getIntent();
        if (!QuizActivity.check) {
            //Storing value of Language name and passing it it getCategory method
            Language = intent.getStringExtra(LanguageAdaptor.LANGUAGE_POSITION);
            mTitle.setText(Language);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(new MyAdaptor(this, helper.getCategory(Language)));
        } else {
            String lang = intent.getStringExtra("LANG_NAME");
            mTitle.setText(lang);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(new MyAdaptor(this, helper.getCategory(lang)));
        }
        Log.d(TAG, "onCreate: Category Activity");
    }

    @Override
    public void onBackPressed() {
        flag = true;
        startActivity(new Intent(this, LanguagesActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home/back button
            case android.R.id.home:
                startActivity(new Intent(this, LanguagesActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Category Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Category Activity");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Category Activity");
        if (flag) {
            finish();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Category Activity");
    }

}

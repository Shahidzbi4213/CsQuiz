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
    public static RecyclerView mRecyclerView;
    //flag to check if back button is pressed to finish the activity
    private static boolean flag;
    private Toolbar toolbar;
    private String Language;
    private TextView mTitle;
    //Helper Class Variable to get reference
    private MyDbOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        toolbar = findViewById(R.id.mToolbar);
        mTitle = toolbar.findViewById(R.id.toolBarTitle);
        mRecyclerView = findViewById(R.id.category);
        helper = new MyDbOpenHelper(this);

        try {

            setSupportActionBar(toolbar);
            toolbar.setElevation((float) 10.00);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            final Drawable backArrow = getResources().getDrawable(R.drawable.back_arrow);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        } catch (NullPointerException e) {
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdaptor(this, helper.getCategory(LanguageAdaptor.LANGUAGE_NAME)));
        Log.d(TAG, "onCreate: Category Activity");
    }

    @Override
    public void onBackPressed() {
        flag = true;
        startActivity(new Intent(this, LanguagesActivity.class));
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

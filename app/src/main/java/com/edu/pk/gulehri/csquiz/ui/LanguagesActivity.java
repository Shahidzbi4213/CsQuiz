package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.LanguageAdaptor;

public class LanguagesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Toolbar toolbar;
    private static long backPressedTime;
    private static boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);


        toolbar = findViewById(R.id.myToolbar);

        try {

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            final Drawable backArrow = getResources().getDrawable(R.drawable.back_arrow);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        } catch (NullPointerException e) {
        }

        mRecyclerView = findViewById(R.id.languages);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(new LanguageAdaptor(this));
    }

    @Override
    public void onBackPressed() {
        flag = true;
        startActivity(new Intent(this, StartQuizActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (flag) {
            finish();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home/back button
            case android.R.id.home:
                startActivity(new Intent(this, StartQuizActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
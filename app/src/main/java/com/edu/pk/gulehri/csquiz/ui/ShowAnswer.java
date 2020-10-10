package com.edu.pk.gulehri.csquiz.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.AnswerAdaptor;
import com.edu.pk.gulehri.csquiz.adaptor.MyAdaptor;

public class ShowAnswer extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        mRecyclerView = findViewById(R.id.showAnswerRecycle);
        mToolbar = findViewById(R.id.mToolbar);

        try {
            Intent intent = getIntent();
            String item = intent.getExtras().getString(MyAdaptor.ITEM_NAME);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle(item);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AnswerAdaptor());
    }
}
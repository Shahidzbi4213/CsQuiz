package com.edu.pk.gulehri.csquiz.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.AnswerAdaptor;

public class ShowAnswer extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        mRecyclerView = findViewById(R.id.showAnswerRecycle);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AnswerAdaptor());
    }
}
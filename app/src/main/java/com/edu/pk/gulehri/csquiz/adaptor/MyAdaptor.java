package com.edu.pk.gulehri.csquiz.adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.Database.Constants;
import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.ui.QuizActivity;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {
    public static final String ITEM_POSITION = "POSITION";
    public static final String LANGUAGE = "Language";
    public static int COUNT;
    private Context context;
    private Cursor mCursor;
    public static String ITEM_NAME;
    private String language;

    public MyAdaptor(Context context) {
        this.context = context;
    }

    public MyAdaptor(Context context, Cursor mCursor) {
        this.context = context;
        this.mCursor = mCursor;

    }


    @NonNull
    @Override
    public MyAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdaptor.MyViewHolder holder, final int position) {
         /* This method will return true if the request destination was reachable,
          otherwise, it returns false.*/
        if (!mCursor.moveToPosition(position)) {
            return;
        }
        final String Category = mCursor.getString(mCursor.getColumnIndex(Constants.COLUMN_CATEGORY_SECOND));
        holder.textView.setText(Category);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ITEM_NAME = Category;
                language = LanguageAdaptor.LANGUAGE_NAME;
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra(ITEM_POSITION, ITEM_NAME);
                intent.putExtra(LANGUAGE, language);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        COUNT = mCursor.getCount();
        return COUNT;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

    }
}
package com.edu.pk.gulehri.csquiz.adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.Database.MyDbOpenHelper;
import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.model.Languages;
import com.edu.pk.gulehri.csquiz.ui.Category;
import com.edu.pk.gulehri.csquiz.ui.QuizActivity;
import com.edu.pk.gulehri.csquiz.ui.ShowAnswer;

public class LanguageAdaptor extends RecyclerView.Adapter<LanguageAdaptor.MyViewHolder> {

    public static final String LANGUAGE_POSITION = "POSITION";
    private Context context;
    public static String LANGUAGE_NAME;

    //Helper Class Variable to get reference
    private MyDbOpenHelper helper;

    public LanguageAdaptor(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public LanguageAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.language_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LanguageAdaptor.MyViewHolder holder, final int position) {
        holder.textView.setText(Languages.CsLanguages[position].getNames());
        holder.imageView.setImageResource(Languages.CsLanguages[position].getImgID());
        LANGUAGE_NAME = String.valueOf(Languages.CsLanguages[position].Names);
        helper= new MyDbOpenHelper(context);
        int count = helper.getCategory(LANGUAGE_NAME).getCount();
        holder.textView1.setText("Categories " + count);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LANGUAGE_NAME = String.valueOf(Languages.CsLanguages[position].Names);
                Intent intent = new Intent(context, Category.class);
                intent.putExtra(LANGUAGE_POSITION, LANGUAGE_NAME);
                QuizActivity.check = false;
                ShowAnswer.check = false;
                context.startActivity(intent);
                ((Activity)context).finish();

            }
        });
    }


    @Override
    public int getItemCount() {
        return Languages.CsLanguages.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView1;
        ImageView imageView;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.languageName);
            textView1 = itemView.findViewById(R.id.categoryCount);
            imageView = itemView.findViewById(R.id.imgIcon);
        }

    }
}
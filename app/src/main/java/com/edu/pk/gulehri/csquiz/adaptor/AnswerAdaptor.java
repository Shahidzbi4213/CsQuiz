package com.edu.pk.gulehri.csquiz.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.ui.QuizActivity;

public class AnswerAdaptor extends RecyclerView.Adapter<AnswerAdaptor.MyViewHolder> {

    @NonNull
    @Override
    public AnswerAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnswerAdaptor.MyViewHolder holder, final int position) {
        QuizActivity.currentQuestion = QuizActivity.questionList.get(position);
        holder.textView1.setText(QuizActivity.currentQuestion.getQuestion());
        int answerNumber = QuizActivity.currentQuestion.getAnswer();
        switch (answerNumber) {
            case 1:
                holder.textView2.setText("Answer: " + QuizActivity.currentQuestion.getOption1());
                break;
            case 2:
                holder.textView2.setText("Answer: " + QuizActivity.currentQuestion.getOption2());
                break;
            case 3:
                holder.textView2.setText("Answer: " + QuizActivity.currentQuestion.getOption3());
                break;
            case 4:
                holder.textView2.setText("Answer: " + QuizActivity.currentQuestion.getOption4());
                break;
            default:
                holder.textView2.setText("Answer: ");
        }

    }

    @Override
    public int getItemCount() {
        return QuizActivity.questionList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.myQuestion);
            textView2 = itemView.findViewById(R.id.myAnswer);
        }

    }
}
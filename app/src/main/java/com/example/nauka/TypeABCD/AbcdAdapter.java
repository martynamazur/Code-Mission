package com.example.nauka.TypeABCD;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nauka.R;

import java.util.ArrayList;

public class AbcdAdapter extends RecyclerView.Adapter<AbcdAdapter.AbcdViewHolder> {

    private ArrayList<String> questionList;
    private Context context;
    private int lastSelectedIndex = -1;

    public AbcdAdapter(ArrayList<String> questionList, Context context) {
        this.questionList = questionList;
        this.context = context;
    }

    @NonNull
    @Override
    public AbcdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.abcd_item, parent, false);
        return new AbcdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbcdViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String question = questionList.get(position);
        holder.answerButton.setText(question);


        //to zmienic i usatwic styl
        if (position == lastSelectedIndex) {
            //holder.answerButton.setBackgroundColor("@drawable/button_question");


        } else {
            holder.answerButton.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previousSelectedIndex = lastSelectedIndex;
                lastSelectedIndex = position;

                notifyItemChanged(previousSelectedIndex);
                notifyItemChanged(lastSelectedIndex);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class AbcdViewHolder extends RecyclerView.ViewHolder {
        Button answerButton;

        public AbcdViewHolder(@NonNull View itemView) {
            super(itemView);
            answerButton = itemView.findViewById(R.id.anwser_block);
        }
    }
}

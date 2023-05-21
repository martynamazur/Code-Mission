package com.example.nauka.hint_quiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;
import com.example.nauka.language.LanguageAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HintAdapter extends RecyclerView.Adapter<HintAdapter.HintViewHolder> {

    private Context context;
    private ArrayList<HintModel> hintList;


    public HintAdapter(Context context, ArrayList<HintModel> hintList) {
        this.context = context;
        this.hintList = hintList;
    }



    @NonNull
    @Override
    public HintAdapter.HintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_abcd_template, parent, false);
        return new HintAdapter.HintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HintAdapter.HintViewHolder holder, int position) {
            HintModel hint = hintList.get(position);
            holder.countTextView.setText(hint.getCount());

            @SuppressLint("DiscouragedApi") int resourceId = context.getResources().getIdentifier(hint.getIconPath(), "drawable", context.getPackageName());
            holder.icon_hint.setImageResource(resourceId);


    }

    @Override
    public int getItemCount() {
        return hintList.size();
    }

    public class HintViewHolder extends RecyclerView.ViewHolder{
        ImageView icon_hint;
        TextView  countTextView;

        public HintViewHolder(@NonNull View itemView) {
            super(itemView);
            icon_hint = itemView.findViewById(R.id.icon_hint);
            countTextView = itemView.findViewById(R.id.countTextView);

        }


    }
}

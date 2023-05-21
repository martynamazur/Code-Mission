package com.example.nauka.language;



import static com.mysql.cj.util.Util.getPackageName;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

    private List<LanguageModel> languageList; // Przykładowa lista języków
    private Context context;
    private OnLanguageClickListener onLanguageClickListener;


    public LanguageAdapter(List<LanguageModel> languageList, Context context) {
        this.languageList = languageList;
        this.context = context;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_item, parent, false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LanguageModel language = languageList.get(position);

        holder.language_name.setText(language.getName());
        holder.picked_language.setChecked(language.isSelected());

        @SuppressLint("DiscouragedApi") int resourceId = context.getResources().getIdentifier(language.getFlagIcon(), "drawable", context.getPackageName());
        holder.flag_icon.setImageResource(resourceId);

        // nasluchuje ktory element checkboxa zostal klikniety
        holder.picked_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLanguageClickListener != null) {
                    onLanguageClickListener.onLanguageClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder {

        TextView language_name;
        CheckBox picked_language;
        ImageView flag_icon;

        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);
            language_name = itemView.findViewById(R.id.language_name);
            picked_language = itemView.findViewById(R.id.picked_language);
            flag_icon = itemView.findViewById(R.id.flag_icon);

        }
    }

    public void setOnLanguageClickListener(OnLanguageClickListener listener) {
        this.onLanguageClickListener = listener;
    }


    public interface OnLanguageClickListener {
        void onLanguageClick(int position);
    }

}

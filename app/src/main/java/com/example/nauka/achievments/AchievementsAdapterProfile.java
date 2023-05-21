package com.example.nauka.achievments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AchievementsAdapterProfile extends RecyclerView.Adapter<AchievementsAdapterProfile.MessageViewHolder>{

    @NonNull
    @Override
    public AchievementsAdapterProfile.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsAdapterProfile.MessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        // Deklaruj widoki, które będą wykorzystywane w elemencie listy
        TextView textViewTitle;
        ImageView imageViewIcon;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicjalizuj widoki na podstawie ich identyfikatorów
            //textViewTitle = itemView.findViewById(R.id.textViewTitle);
            //imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
        }}}


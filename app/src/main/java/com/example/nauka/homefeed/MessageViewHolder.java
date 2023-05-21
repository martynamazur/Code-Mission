package com.example.nauka.homefeed;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    public TextView naglowek;
    public TextView tresc;

    public MessageViewHolder(View itemView) {
        super(itemView);
        naglowek = itemView.findViewById(R.id.naglowek);
        tresc = itemView.findViewById(R.id.tresc);
    }
}
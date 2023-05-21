package com.example.nauka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messages; // Lista wiadomości

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View messageView = inflater.inflate(R.layout.message_item, parent, false);

        // Return a new holder instance
        return new MessageViewHolder(messageView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        // Get the data model based on position
        Message message = messages.get(position);

        // Set the text of the TextViews to the corresponding values from the message

        holder.headerTextView.setText(message.getHeader());
        holder.contentTextView.setText(message.getContent());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    /*
    W skrócie, klasa MessageViewHolder reprezentuje
    pojedynczy element listy w RecyclerView i przechowuje referencje
    do poszczególnych widoków w tym elemencie, co umożliwia ich dostęp
    i manipulację podczas wyświetlania danych.
     */
    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView headerTextView;
        TextView contentTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.naglowek);
            contentTextView = itemView.findViewById(R.id.tresc);
        }
    }
}

package com.example.nauka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private ArrayList<Message> listaWiadomosci;

    public MessageAdapter(ArrayList<Message> messages) {
        this.listaWiadomosci = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message wiadomosc = listaWiadomosci.get(position);
        holder.naglowek.setText(wiadomosc.getTitle());
        holder.tresc.setText(wiadomosc.getContent());
        //holder.tab.setText(wiadomosc.getTitle()); // set text on TabLayout.Tab object

    }


    @Override
    public int getItemCount() {
        return listaWiadomosci.size();
    }

    public static class WiadomosciViewHolder extends RecyclerView.ViewHolder {
        TextView naglowek;
        TextView tresc;

        public WiadomosciViewHolder(View itemView) {
            super(itemView);
            naglowek = itemView.findViewById(R.id.naglowek);
            tresc = itemView.findViewById(R.id.tresc);
        }
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView naglowek;
        public TextView tresc;
        //public ActionBar.Tab naglowek;
        //public ActionBar.Tab tresc;

        public MessageViewHolder(View itemView) {
            super(itemView);
            naglowek = itemView.findViewById(R.id.naglowek);
            tresc = itemView.findViewById(R.id.tresc);

        }
    }

}

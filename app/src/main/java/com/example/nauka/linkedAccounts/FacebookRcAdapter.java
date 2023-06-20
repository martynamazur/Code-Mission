package com.example.nauka.linkedAccounts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;

import java.util.ArrayList;

public class FacebookRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<AccountInformationModel> accInfList;
    private static final int VIEW_TYPE_EMPTY = 0; // Wartość reprezentująca brak konta
    private static final int VIEW_TYPE_ACCOUNT = 1; // Wartość reprezentująca konto

    public FacebookRcAdapter(Context context, ArrayList<AccountInformationModel> accInfList) {
        this.context = context;
        this.accInfList = accInfList;
    }

    @Override
    public int getItemViewType(int position) {
        if (accInfList.isEmpty()) {
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_ACCOUNT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_EMPTY) {
            View emptyView = LayoutInflater.from(context).inflate(R.layout.connected_acc_item, parent, false);
            return new EmptyViewHolder(emptyView);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.connected_acc_item, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AccountViewHolder) {
            AccountViewHolder accountViewHolder = (AccountViewHolder) holder;
            AccountInformationModel accountInformationModel = accInfList.get(position);
            accountViewHolder.emailText.setText(accountInformationModel.getEmail());
        } else if (holder instanceof EmptyViewHolder) {
            // Obsłuż ViewHolder reprezentujący brak konta
            EmptyViewHolder emptyViewHolder = (EmptyViewHolder) holder;
            // Ustaw odpowiednie teksty lub style
        }
    }

    @Override
    public int getItemCount() {
        return accInfList.size();
    }

    public static class AccountViewHolder extends RecyclerView.ViewHolder {
        Button unlinked;
        TextView emailText;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            unlinked = itemView.findViewById(R.id.unlinkedAccount);
            emailText = itemView.findViewById(R.id.emailText);
        }
    }

    public static class EmptyViewHolder extends RecyclerView.ViewHolder {
        TextView emptyTextView;

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
            emptyTextView = itemView.findViewById(R.id.emptyTextView);
        }
    }
}

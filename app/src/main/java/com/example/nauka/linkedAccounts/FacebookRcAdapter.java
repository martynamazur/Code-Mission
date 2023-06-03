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
import com.example.nauka.achievments.AchievementsAdapter;
import com.example.nauka.linkedAccounts.AccountInformationModel;

import java.util.ArrayList;

public class FacebookRcAdapter extends RecyclerView.Adapter<FacebookRcAdapter.FacebookRcViewHolder> {

    private Context context;
    private ArrayList<AccountInformationModel> accInfList;

    public FacebookRcAdapter(Context context, ArrayList<AccountInformationModel> accInfList) {
        this.context = context;
        this.accInfList = accInfList;
    }


    @NonNull
    @Override
    public FacebookRcAdapter.FacebookRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.connected_acc_item, parent, false);
        return new FacebookRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacebookRcAdapter.FacebookRcViewHolder holder, int position) {
        AccountInformationModel accountInformationModel = accInfList.get(position);
        holder.emailText.setText(accountInformationModel.getEmail());
    }

    @Override
    public int getItemCount() {
        System.out.println(accInfList);
        return accInfList.size();
    }

    public static class FacebookRcViewHolder extends RecyclerView.ViewHolder {
        Button unlinked;
        TextView emailText;

        public FacebookRcViewHolder(@NonNull View itemView) {
            super(itemView);
            unlinked = itemView.findViewById(R.id.unlinkedAccount);
            emailText = itemView.findViewById(R.id.emailText);
        }
    }
}

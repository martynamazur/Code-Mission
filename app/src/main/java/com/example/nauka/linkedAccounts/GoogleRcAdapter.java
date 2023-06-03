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
import com.example.nauka.linkedAccounts.AccountInformationModel;

import java.util.ArrayList;

public class GoogleRcAdapter extends RecyclerView.Adapter<GoogleRcAdapter.GoogleRcViewHolder> {

    private Context context;
    private ArrayList<AccountInformationModel> accInfList;

    public GoogleRcAdapter(Context context, ArrayList<AccountInformationModel> accInfList) {
        this.context = context;
        this.accInfList = accInfList;
    }

    @NonNull
    @Override
    public GoogleRcAdapter.GoogleRcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.connected_acc_item, parent, false);
        return new GoogleRcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoogleRcAdapter.GoogleRcViewHolder holder, int position) {
        AccountInformationModel accountInformationModel = accInfList.get(position);
        holder.emailText.setText(accountInformationModel.getEmail());
    }

    @Override
    public int getItemCount() {
        return accInfList.size();
    }

    public class GoogleRcViewHolder extends RecyclerView.ViewHolder {
        Button unlinked;
        TextView emailText;

        public GoogleRcViewHolder(@NonNull View itemView) {
            super(itemView);
            unlinked = itemView.findViewById(R.id.unlinkedAccount);
            emailText = itemView.findViewById(R.id.emailText);
        }
    }
}

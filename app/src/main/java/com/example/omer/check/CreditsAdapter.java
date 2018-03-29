package com.example.omer.check;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Omer on 16/03/2018.
 */

class CreditsAdapter extends RecyclerView.Adapter<CreditsAdapter.CreditsViewHolder> {
    List<Credits> list;
    CreditsActivity creditsActivity;

    CreditsAdapter(List<Credits> list, CreditsActivity creditsActivity) {
        this.list = list;
        this.creditsActivity = creditsActivity;
    }

    @NonNull
    @Override
    public CreditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.credits_card_view, parent, false);
        CreditsViewHolder creditsViewHolder = new CreditsViewHolder(v);

        return creditsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreditsViewHolder holder, int position) {
        holder.companyName.setText(" " + list.get(position).getCompanyName());
        holder.sum.setText(String.valueOf(list.get(position).getSumOfCredit()));
        holder.companyPic.setImageResource(R.drawable.picture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class CreditsViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView companyName, sum;
        ImageView companyPic;


        public CreditsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.creditsCardView);
            companyName = (TextView) itemView.findViewById(R.id.companyName);
            sum = (TextView) itemView.findViewById(R.id.sum);
            companyPic = (ImageView) itemView.findViewById(R.id.companyPicture);
        }
    }
}

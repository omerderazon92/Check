package com.example.omer.check;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Omer on 07/03/2018.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ProgressBarViewHoler> {

    List<Product> list;
    MainActivity mainActivity;
    boolean[] flagFoAnimation;

    RvAdapter(List<Product> list, MainActivity mainActivity) {
        this.list = list;
        this.mainActivity = mainActivity;
        this.flagFoAnimation = new boolean[list.size()];
    }

    @Override
    public ProgressBarViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ProgressBarViewHoler progressBarViewHoler = new ProgressBarViewHoler(v);

        return progressBarViewHoler;
    }

    @Override
    public void onBindViewHolder(final ProgressBarViewHoler holder, final int position) {
        //holder.pb.setProgress(list.get(position).getPrecent());
        progressBarAndCounterAnimation(holder, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, WarrantyDetails.class);
                intent.putExtra("Product", list.get(position));
                mainActivity.startActivity(intent);
            }
        });


    }

    private void progressBarAndCounterAnimation(final ProgressBarViewHoler holder, final int position) {

        //set the color of the progress bar
        if (list.get(position).getPrecent() <= 50) {
            holder.pb.getProgressDrawable().setColorFilter(holder.itemView.getResources().getColor(R.color.colorRedForProgressBar), PorterDuff.Mode.SRC_ATOP);
        } else if (list.get(position).getPrecent() > 50) {
            holder.pb.getProgressDrawable().setColorFilter(holder.itemView.getResources().getColor(R.color.colorGreenForProgressBar), PorterDuff.Mode.SRC_ATOP);
        }

//        set the animation of the progress bar
        if (flagFoAnimation[position] == false) {

            ProgressBarAnimation anim = new ProgressBarAnimation(holder.pb, 0, list.get(position).getPrecent());
            anim.setDuration(1500);
            holder.pb.startAnimation(anim);

            flagFoAnimation[position] = true;


            ValueAnimator valueAnimator = ValueAnimator.ofInt(list.get(position).totalWrranty > 100 ? 100 : 0, list.get(position).getTotalWrranty());
            valueAnimator.setDuration(2000);

            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    holder.daysCounter.setText(valueAnimator.getAnimatedValue().toString());

                }
            });
            valueAnimator.start();

        } else if (flagFoAnimation[position] == true) {
            holder.pb.setProgress(list.get(position).getPrecent());
        }

        holder.daysCounter.setText(String.valueOf(list.get(position).getTotalWrranty()));

        holder.companyName.setText(list.get(position).getCompany() + " " + "-");
        holder.name.setText(list.get(position).getNameOfProduct());


        //set the image
        holder.companyPic.setImageResource(R.drawable.picture);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProgressBarViewHoler extends RecyclerView.ViewHolder {
        CardView cv;
        android.widget.ProgressBar pb;
        TextView name, daysCounter, companyName;
        ImageView companyPic;

        public ProgressBarViewHoler(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.mainCardView);
            pb = (ProgressBar) itemView.findViewById(R.id.progressBar);
            name = (TextView) itemView.findViewById(R.id.nameOfProduct);
            daysCounter = (TextView) itemView.findViewById(R.id.daysCounter);
            companyName = (TextView) itemView.findViewById(R.id.companyName);
            companyPic = (ImageView) itemView.findViewById(R.id.companyPicture);
            pb.setScaleY((float) 0.5);

        }
    }
}

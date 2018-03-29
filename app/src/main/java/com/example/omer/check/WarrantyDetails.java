package com.example.omer.check;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Omer on 08/03/2018.
 */

public class WarrantyDetails extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warranty_details_activity);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView actionbar = (TextView) findViewById(R.id.mytext);
        actionbar.setText("פרטי האחריות");

        Product product = (Product) getIntent().getSerializableExtra("Product");
        ProgressBar progressBar = (findViewById(R.id.progressBar2));
        progressBar.setScaleY((float) 0.6);

        //set the color of the progress bar
        if (product.getPrecent() > 50) {
            progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorGreenForProgressBar), PorterDuff.Mode.SRC_ATOP);
        } else if (product.getPrecent() <= 50) {
            progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorRedForProgressBar), PorterDuff.Mode.SRC_ATOP);
        }

        //progress bar animation
        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0, product.getPrecent());
        anim.setDuration(1500);
        progressBar.startAnimation(anim);

        TextView textView = (TextView) findViewById(R.id.itemandcompany);
        textView.setText(product.companyName + " " + product.nameOfProduct);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(R.drawable.picture);

        //   TextView productInfo = (TextView) findViewById(R.id.productInfo);

        final Button closetBranches = findViewById(R.id.findClosetBranches);
//ASK ALON
        closetBranches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WarrantyDetails.this, MapsActivity.class);
                WarrantyDetails.this.startActivity(intent);

            }
        });

        TextView warrantyDetails = findViewById(R.id.warrantyDetails);
        warrantyDetails.setText(product.warrantyDetails);


    }


}

package com.example.omer.check;

import android.bluetooth.BluetoothAssignedNumbers;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Omer on 12/03/2018.
 */

public class Starting extends AppCompatActivity {

    ImageView images;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_dashboard);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView actionbar = (TextView) findViewById(R.id.mytext);
        actionbar.setText("My Guarantee");

        final RelativeLayout warrantyButton = (RelativeLayout) findViewById(R.id.warrantyButton);
        warrantyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout creditsButton = (RelativeLayout) findViewById(R.id.creditButton);
        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreditsActivity.class);
                startActivity(intent);
            }
        });


        images = (ImageView) findViewById(R.id.warrantyImage);
        images.setImageResource(R.drawable.warranty);
        images = (ImageView) findViewById(R.id.creditsImage);
        images.setImageResource(R.drawable.exchange);
        images = (ImageView) findViewById(R.id.fixesImage);
        images.setImageResource(R.drawable.repair);


    }
}

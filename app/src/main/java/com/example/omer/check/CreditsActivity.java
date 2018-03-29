package com.example.omer.check;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omer on 16/03/2018.
 */

public class CreditsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CreditsAdapter creditsAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_layut);

        List<Credits> creditsList = new ArrayList<>();
        Credits credits1 = new Credits("IceWatch", 150);
        creditsList.add(credits1);


        recyclerView = (RecyclerView) findViewById(R.id.creditsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        creditsAdapter = new CreditsAdapter(creditsList, this);
        recyclerView.setAdapter(creditsAdapter);
    }

}

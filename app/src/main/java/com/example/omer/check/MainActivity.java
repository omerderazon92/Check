package com.example.omer.check;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    RvAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView actionbar = (TextView) findViewById(R.id.mytext);
        actionbar.setText("מוצרים באחריות");


        Product nameOfProduct = new Product(50, "שעון", 300, "IceWatch");
        Product progressBar3 = new Product(75, "שעון", 300, "IceWatch");
        Product progressBar4 = new Product(20, "שעון", 25, "IceWatch");

        List<Product> progressBarList = new ArrayList<>();
        progressBarList.add(nameOfProduct);
        progressBarList.add(progressBar3);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);
        progressBarList.add(progressBar4);

        Collections.sort(progressBarList);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rvAdapter = new RvAdapter(progressBarList, this);
        recyclerView.setAdapter(rvAdapter);


    }
}

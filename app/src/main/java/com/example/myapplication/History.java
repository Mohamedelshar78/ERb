package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.Adapters.Adapterforrecyclerview;
import com.example.myapplication.Models.HIstoryModel;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    RecyclerView history_recycler;
    private LinearLayout detailsLayout;
    Adapterforrecyclerview adapterforrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_card);


        history_recycler=findViewById(R.id.history_rec);


     //   detailsLayout = findViewById(R.id.contentLayout);


        HIstoryModel hIstoryModel=new HIstoryModel(
                true,
                "18/8",
                "Ottrex 18x54 Anti pollen Mesh screen",
                "Price: 30 L.E / meter",
                "Quantity: 2",
                "Applicable fees: 10 L.E"
                );


        ArrayList<HIstoryModel>hIstoryModels=new ArrayList<>();
        hIstoryModels.add(hIstoryModel);
        hIstoryModels.add(hIstoryModel);
        hIstoryModels.add(hIstoryModel);
        hIstoryModels.add(hIstoryModel);

        adapterforrecyclerview=new Adapterforrecyclerview(hIstoryModels,this);


        history_recycler.setAdapter(adapterforrecyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        history_recycler.setLayoutManager(layoutManager);
































    }

    public void toggleDetails(View view) {
        ImageView expandCollapseIcon = findViewById(R.id.showdetails);

        if (detailsLayout.getVisibility() == View.VISIBLE) {
            detailsLayout.setVisibility(View.GONE);
            expandCollapseIcon.setImageResource(R.drawable.spinnericon); // Set expand icon
        } else {
            detailsLayout.setVisibility(View.VISIBLE);
            expandCollapseIcon.setImageResource(R.drawable.collapce_spinner); // Set collapse icon
        }
    }

}
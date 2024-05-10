package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.HIstoryModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Adapterforrecyclerview extends RecyclerView.Adapter<Adapterforrecyclerview.MYviewholder> {

    ArrayList<HIstoryModel>histores;
    Context context;

    public Adapterforrecyclerview(ArrayList<HIstoryModel> histores, Context context) {
        this.histores = histores;
        this.context = context;
    }

    @NonNull
    @Override
    public MYviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.cardofhistory,parent,false);


        return new  MYviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYviewholder holder, int position) {

    HIstoryModel hIstoryModel=histores.get(position);

    holder.setdata(hIstoryModel);
    holder.spinner.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            holder.toggleDetails(holder.view);
        }
    });





    }

    @Override
    public int getItemCount() {
        return histores.size();
    }

    class MYviewholder extends RecyclerView.ViewHolder {

    CheckBox checkBox;
    TextView data_of,name_of_product,price_of_product,quantity_product;
    ImageView spinner,reorder;
    private LinearLayout detailsLayout;

    View view;

      public MYviewholder(View view) {
          super(view);
          this.view=view;
          checkBox=view.findViewById(R.id.check_deleverd);
          data_of=view.findViewById(R.id.delivary_date);
          name_of_product=view.findViewById(R.id.productname);
          price_of_product=view.findViewById(R.id.price);
          quantity_product=view.findViewById(R.id.quantity_text);
          spinner=view.findViewById(R.id.showdetails);
          reorder=view.findViewById(R.id.reorder);
          detailsLayout = view.findViewById(R.id.contentLayout);






      }


      public void setdata(HIstoryModel hIstoryModel){

          if(hIstoryModel.isDeleverd()){
              checkBox.setChecked(true);
          }
          data_of.setText(hIstoryModel.getDate());
          name_of_product.setText(hIstoryModel.getProduct_name());
          price_of_product.setText(hIstoryModel.getPrice());
          quantity_product.setText(hIstoryModel.getQuantity());
      }
        public void toggleDetails(View view) {
            ImageView expandCollapseIcon =view.findViewById(R.id.showdetails);

            if (detailsLayout.getVisibility() == View.VISIBLE) {
                detailsLayout.setVisibility(View.GONE);
                expandCollapseIcon.setImageResource(R.drawable.spinnericon); // Set expand icon
            } else {
                detailsLayout.setVisibility(View.VISIBLE);
                expandCollapseIcon.setImageResource(R.drawable.collapce_spinner); // Set collapse icon
            }
        }



  }

}

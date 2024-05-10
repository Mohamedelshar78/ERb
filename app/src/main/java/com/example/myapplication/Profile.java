package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView goto_personal_information,logout,history;
    ImageView history_imag;

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        goto_personal_information=findViewById(R.id.Personal_information);
        logout=findViewById(R.id.Log_Out);

        history=findViewById(R.id.text_history);
        history_imag=findViewById(R.id.history_image);




        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_hostory_page();
            }
        });
        history_imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_hostory_page();
            }
        });





        dialog=new Dialog(Profile.this);



        goto_personal_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Personal_information.class));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializedialog();
            }
        });









    }


    private  void goto_hostory_page(){
        startActivity(new Intent(Profile.this, History.class));
    }

    private void initializedialog(){
        dialog.setContentView(R.layout.dialogforlogout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);


        Button cancel_bt,logout_bt;
        cancel_bt=dialog.findViewById(R.id.cancel);
        logout_bt=dialog.findViewById(R.id.logout);


        cancel_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        logout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Login.class));
                finish();

            }
        });





        dialog.show();





    }
}
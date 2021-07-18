package com.example.quizproject;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private ImageView btn , call_img , eml_img ;
    private Button play ;
    TextView ins ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn = findViewById(R.id.prof);
        play = findViewById(R.id.play_btn);
        call_img = findViewById(R.id.call_img);
        eml_img = findViewById(R.id.email_img);

            ins = findViewById(R.id.inst);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this , profile.class);
                startActivity(intent);
            }
        });

        call_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this , Call.class);
                startActivity(intent);


            }
        });

        eml_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this , Email_Activity.class);
                startActivity(intent);

            }
        });



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this , com.example.quizproject.DashboardActivity.class);
                startActivity(intent);

            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInst();
            }
        });


    }

    private void goToInst() {
        Uri uri = Uri.parse("https://www.instagram.com/snehamusicworld/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/snehamusicworld/")));
        }
    }
}
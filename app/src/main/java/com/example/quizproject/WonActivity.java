package com.example.quizproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText;
    int correct,wrong;
    LinearLayout btnShare;
    ImageView  btn ;
    TextView ext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        ext = findViewById(R.id.ic_exit);
        btn = findViewById(R.id.ic_back);

        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });


        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);


        circularProgressBar=findViewById(R.id.circularProgressBar);
        resultText=findViewById(R.id.resultText);
        btnShare=findViewById(R.id.btnShare);

        circularProgressBar.setProgress(correct);
        resultText.setText(correct+"/5");






        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\ni got "+correct+"Out of 20 You Can Also Try ";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

    }
    private  void exit()
    {
        Intent intent = new Intent(WonActivity.this , Home.class);
        startActivity(intent);
    }



}
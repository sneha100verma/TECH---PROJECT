package com.example.quizproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class profile extends AppCompatActivity {

    private DatabaseReference reference;
    private FirebaseUser user;
    private String userId ;
    private Button logout;
    private EditText txt ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);


        logout = findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(profile.this , com.example.quizproject.Login.class));
            }
        });






        TextView name = (TextView)findViewById(R.id.name);
        TextView eml = (TextView)findViewById(R.id.eml);
        txt = (EditText)findViewById(R.id.nme);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url



            String email = user.getEmail();
           String naam = user.getUid();





                eml.setText(email);
                name.setText(naam);





        }

    }







    }

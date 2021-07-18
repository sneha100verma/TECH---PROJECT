package com.example.quizproject;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up extends AppCompatActivity {

    private EditText mEmail, mPass;
    private Button reg_Btn;
    private FirebaseAuth mAuth;
    private EditText txt ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);





        mEmail = findViewById(R.id.eml);
        mPass = findViewById(R.id.pw);
        reg_Btn = findViewById(R.id.reg_btn);

        txt = (EditText)findViewById(R.id.nme);


        mAuth = FirebaseAuth.getInstance();

        TextView Text = new TextView(this);
        Text = findViewById(R.id.log);

        reg_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }


        });




        Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_up.this, com.example.quizproject.Login.class);
                startActivity(intent);


            }

        });

    }
    private void createUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Toast.makeText(Sign_up.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_up.this , com.example.quizproject.Home.class));
                                finish();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Sign_up.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                mPass.setError("Empty Fields Are not Allowed");
            }
        }else if(email.isEmpty()){
            mEmail.setError("Empty Fields Are not Allowed");
        }else{
            mEmail.setError("Pleas Enter Correct Email");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

}
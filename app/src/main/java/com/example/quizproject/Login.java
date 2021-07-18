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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText mEmail, mPass;
    private Button signInBtn;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmail = findViewById(R.id.eml_in);
        mPass = findViewById(R.id.pass_in);
        signInBtn = findViewById(R.id.log_btn);
        mAuth = FirebaseAuth.getInstance();



        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });



        TextView Text = new TextView(this);
        Text = findViewById(R.id.reg);

        Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , Sign_up.class);
                startActivity(intent);

            }








        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    private void loginUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email , pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this , Home.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
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











}
package com.example.umlmentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    Button createAccountbtn;
    Button cancelBtn;
    EditText firstName, lastName, userName, password, confirmPassword, major, email;


    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        userName = (EditText) findViewById(R.id.etUserName);
        password = (EditText) findViewById(R.id.etPassword);
        confirmPassword = (EditText) findViewById(R.id.etRePassword);
        major = (EditText) findViewById(R.id.etMajor);
        email = (EditText) findViewById(R.id.etEmail);
        createAccountbtn = (Button) findViewById(R.id.btnCreateAccount);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        firebaseAuth = FirebaseAuth.getInstance();
        createAccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                        password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Register.this,"Registered Successfully", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Register.this, task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelRegistration();
            }
        });
    }

    public void cancelRegistration() {
        Intent intent = new Intent();
        intent.setClass(Register.this, MainActivity.class);
        startActivity(intent);
    }
}
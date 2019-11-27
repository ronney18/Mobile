package com.example.umlmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {

    private Button logoutBtn;
    private Button createPostBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        firebaseAuth = FirebaseAuth.getInstance();
        logoutBtn = (Button) findViewById(R.id.btnLogout);
        createPostBtn = (Button) findViewById(R.id.createPostBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Toast.makeText(Homepage.this, "You have logged out!",
                        Toast.LENGTH_LONG);
                finish();
                startActivity(new Intent(Homepage.this, MainActivity.class));
            }
        });

        createPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homepage.this, "Create your post!", Toast.LENGTH_LONG);
                finish();
                startActivity(new Intent(Homepage.this, Post.class));
            }
        });
    }
}

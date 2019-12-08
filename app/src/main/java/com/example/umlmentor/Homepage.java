package com.example.umlmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {

    private Button logoutBtn;
    private Button createPostBtn;
    private Button createSearchBtn;
    private FirebaseAuth firebaseAuth;
    private TextView textSubject;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        firebaseAuth = FirebaseAuth.getInstance();
        logoutBtn = (Button) findViewById(R.id.btnLogout);
        createPostBtn = (Button) findViewById(R.id.createPostBtn);
        createSearchBtn = (Button) findViewById(R.id.createSearchBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Toast.makeText(Homepage.this, "You have logged out successfully!",
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

        createSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homepage.this, "Look up mentors!", Toast.LENGTH_LONG);
                finish();
                startActivity(new Intent(Homepage.this, Mentors.class));
            }
        });

        Intent caller = getIntent();
        String subject = caller.getStringExtra("mySubject");
        String description = caller.getStringExtra("myDescription");
        textSubject = (TextView) findViewById(R.id.subject);
        textDescription = (TextView) findViewById(R.id.description);
        textSubject.setText(subject);
        textDescription.setText(description);
    }
}

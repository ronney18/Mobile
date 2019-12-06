package com.example.umlmentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Post extends AppCompatActivity {

    private Button cancelButton;
    private Button postButton;
    private EditText subject;
    private EditText description;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference postReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        postReference = FirebaseDatabase.getInstance().getReference("students").child("posts");

        subject = (EditText) findViewById(R.id.textTitle);
        description = (EditText) findViewById(R.id.textDescription);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        postButton = (Button) findViewById(R.id.postButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Post.this, Homepage.class));
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(subject.getText().toString().isEmpty() || description.getText().toString()
                        .isEmpty()) {
                    Toast.makeText(Post.this,"Please enter subject and description!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    String subjectText = subject.getText().toString();
                    String descriptionText = description.getText().toString();
                    String id = postReference.push().getKey();
                    String studentName = firebaseUser.getDisplayName();
                    StudentPost studentPost = new StudentPost(id, studentName, subjectText, descriptionText);
                    postReference.child(id).setValue(studentPost);
                    Toast.makeText(Post.this,"Message posted successfully!",
                            Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(view.getContext(), Homepage.class);
                    myIntent.putExtra("name", studentName);
                    myIntent.putExtra("mySubject", subjectText);
                    myIntent.putExtra("myDescription", descriptionText);
                    finish();
                    startActivity(myIntent);
                }
            }
        });
    }
}

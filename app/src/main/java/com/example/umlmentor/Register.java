package com.example.umlmentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    Button createAccountbtn;
    Button cancelBtn;
    EditText firstName, lastName, userName, password, confirmPassword, major, email;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databaseUser = FirebaseDatabase.getInstance().getReference("users");

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
                if((!firstName.getText().toString().isEmpty()) && (!lastName.getText().toString().isEmpty()) &&
                        (!userName.getText().toString().isEmpty()) && (!major.getText().toString().isEmpty()) &&
                        (!email.getText().toString().isEmpty()) && (!password.getText().toString().isEmpty()) &&
                        (!confirmPassword.getText().toString().isEmpty()))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                            password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(Register.this,"Registered Successfully", Toast.LENGTH_LONG).show();
                                addUser();
                                finish();
                                startActivity(new Intent(Register.this, MainActivity.class));
                            }else {
                                Toast.makeText(Register.this, task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(Register.this, "Please enter all the fields!", Toast.LENGTH_LONG).show();
                }

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
                startActivity(new Intent(Register.this, MainActivity.class));
            }

        });

    }
    private void addUser() {
        String userFirstName = firstName.getText().toString().trim();
        String userLastName = lastName.getText().toString().trim();
        String user_name = userName.getText().toString().trim();
        String userMajor = major.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString().trim();
        String userConfirmPassword = confirmPassword.getText().toString().trim();

        if((!TextUtils.isEmpty(userFirstName)) && (!TextUtils.isEmpty(userLastName)) &&
                (!TextUtils.isEmpty(user_name)) && (!TextUtils.isEmpty(userMajor)) &&
                (!TextUtils.isEmpty(userEmail)) && (!TextUtils.isEmpty(userPassword)) &&
                (!TextUtils.isEmpty(userConfirmPassword)))
        {
            String id = databaseUser.push().getKey();
            User user = new User(id, userFirstName, userLastName, user_name, userMajor, userEmail,
                    userPassword, userConfirmPassword);
            databaseUser.child(id).setValue(user);
            Toast.makeText(this, "User Added!", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(this, "Please enter all the fields!", Toast.LENGTH_LONG).show();
        }

    }
}
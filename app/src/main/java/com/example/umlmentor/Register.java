package com.example.umlmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    Button btnCreateAccount;
    EditText etFirstName, etLastName, etUserName, etPassword, etRePassword, etCreateAccount, etMajor, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName  = (EditText) findViewById(R.id.etLastName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etCreateAccount = (EditText) findViewById(R.id.etPassword);
        etMajor = (EditText) findViewById(R.id.etMajor);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

    }

    public void createAccount() {

    }
}

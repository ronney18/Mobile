package com.example.umlmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button login;
    EditText userName, password;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.etUserName);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);
        signUp = (Button) findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomepage();
            }
        });

    }

    private void openRegister() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Register.class);
        startActivity(intent);
    }

    private void openhomepage() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, homepage.class);
        startActivity(intent);
    }
}

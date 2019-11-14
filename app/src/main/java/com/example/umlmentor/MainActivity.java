package com.example.umlmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button btnLogin;
    EditText etUserName, etPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                break;

            case R.id.btn_sign_up:
                Intent gotoSecond = new Intent();
                gotoSecond.setClass(this, Register.class);
                startActivity(gotoSecond);
                break;

        }

    }
}

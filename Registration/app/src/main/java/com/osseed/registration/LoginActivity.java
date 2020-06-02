package com.osseed.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    TextView tvRegister;
    Button btnLogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db  =   new DatabaseHelper(this);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Homepage  = new Intent ( LoginActivity.this,RegisterActivity.class);
                startActivity(Homepage);
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                String user = etEmail.getText().toString().trim();
                String pwd  =  etPassword.getText().toString().trim();
                Boolean res =   db.checkUser(user,pwd);
                if(res == true){
                    //Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent HomePage = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(HomePage);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

    package com.osseed.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText etFname, etLname, etRemail, etRpassword;
    TextView etAregister;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db  = new DatabaseHelper(this);

        etFname = (EditText) findViewById(R.id.et_fname);
        etLname = (EditText) findViewById(R.id.et_Lname);
        etRemail = (EditText) findViewById(R.id.et_reg_email);
        etRpassword = (EditText) findViewById(R.id.et_reg_password);
        etAregister =  (TextView)  findViewById(R.id.tv_already_reg);
        btnRegister =   (Button)findViewById(R.id.btn_register);

        etAregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent  = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etRemail.getText().toString().trim();
                String pwd = etRpassword.getText().toString().trim();
                long val =  db.addUser(user,pwd);
                if(val > 0){
                    Toast.makeText(RegisterActivity.this, "You have Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin  =new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(moveToLogin);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

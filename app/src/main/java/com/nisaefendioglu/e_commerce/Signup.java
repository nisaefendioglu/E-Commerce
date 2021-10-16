package com.nisaefendioglu.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    EditText name, phone, mail, password;
    Button signup;
    TextView login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mAuth = FirebaseAuth.getInstance();
    }

    void init(){

        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.login:
                signup();
                break;
        }
    }

    private void signup(){
        String names = name.getText().toString().trim();
        String phones = phone.getText().toString().trim();
        String mails = mail.getText().toString().trim();
        String passwords = password.getText().toString().trim();

        if(names.isEmpty()){
            name.setError("Name is required!");
            name.requestFocus();
            return;
        }

        if(phones.isEmpty()){
            phone.setError("Phone is required!");
            phone.requestFocus();
            return;
        }

        if(mails.isEmpty()){
            mail.setError("Mail is required!");
            mail.requestFocus();
            return;
        }

        if(passwords.isEmpty()){
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }





    }
}

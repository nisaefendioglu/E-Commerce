package com.nisaefendioglu.e_commerce;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Login extends AppCompatActivity {
    Button login;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
    }

    void init(){
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
    }
}

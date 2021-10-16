package com.nisaefendioglu.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddProduct extends AppCompatActivity
{
    EditText name,desc,price;
    Button submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct);

        name=findViewById(R.id.add_name);
        desc=findViewById(R.id.add_desc);
        price=findViewById(R.id.add_price);

        back=findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        });

        submit=findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> {
            processinsert();
            Toast.makeText(this,"Successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),ProductActivity.class));

        });
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("desc",desc.getText().toString());
        map.put("price",price.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Products").push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    name.setText("");
                    desc.setText("");
                    price.setText("");
                    Toast.makeText(getApplicationContext(),"Successfully",Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show());

    }
}
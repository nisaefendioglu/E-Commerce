package com.nisaefendioglu.e_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ProductActivity extends AppCompatActivity
{
   RecyclerView recview;
   AddProductAdapter adapter;
   FloatingActionButton fb;
   LinearLayout linear;
   TextView textadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        linear = findViewById(R.id.linear);
        textadd = findViewById(R.id.textadd);
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), Model.class)
                        .build();

        adapter=new AddProductAdapter(options, textadd, linear);
        recview.setAdapter(adapter);

        fb=findViewById(R.id.fadd);
        fb.setOnClickListener(view -> {

            startActivity(new Intent(getApplicationContext(), AddProduct.class));



        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
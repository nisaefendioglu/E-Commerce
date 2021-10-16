package com.nisaefendioglu.e_commerce;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,add;
    ListView list_item;
    LinearLayout linear;
    TextView textadd;
    final ArrayList<HomeProductList> productLists = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void init(){
        b1 = findViewById(R.id.b1);
        b1.setBackgroundTintList(null);

        b2 = findViewById(R.id.b2);
        b2.setBackgroundTintList(null);

        b3 = findViewById(R.id.b3);
        b3.setBackgroundTintList(null);

        b4 = findViewById(R.id.b4);
        b4.setBackgroundTintList(null);

        linear = findViewById(R.id.linear);
        textadd = findViewById(R.id.textadd);

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProductActivity.class));

            }
        });

        list_item = findViewById(R.id.list_item);

        productLists.add(new HomeProductList("Make-Up","100 TRY.",R.drawable.makeup));
        productLists.add(new HomeProductList("Jean","180 TRY.",R.drawable.jeans));
        productLists.add(new HomeProductList("Red Dress","100 TRY.",R.drawable.dress));
        productLists.add(new HomeProductList("Bag","80 TRY.",R.drawable.bag));
        productLists.add(new HomeProductList("Make-Up","100 TRY.",R.drawable.makeup));
        productLists.add(new HomeProductList("Jean","180 TRY.",R.drawable.jeans));
        productLists.add(new HomeProductList("Red Dress","100 TRY.",R.drawable.dress));
        productLists.add(new HomeProductList("Bag","80 TRY.",R.drawable.bag));

        HomeProductAdapter mailAdapter = new HomeProductAdapter(this, productLists);
        if (list_item != null) {
            list_item.setAdapter(mailAdapter);
        }


    }
}
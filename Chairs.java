package com.example.e_shop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chairs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chairs);

        View back = findViewById(R.id.backToCategories);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Categories.class);
                startActivity(intent);
            }
        });

        View cart = findViewById(R.id.cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cart.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        View add1 = findViewById(R.id.addChair1);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add1);
            }
        });

        View add2 = findViewById(R.id.addChair2);

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add2);
            }
        });

        View add3 = findViewById(R.id.addChair3);

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add3);
            }
        });

        View add4 = findViewById(R.id.addChair4);

        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add4);
            }
        });
        View add5 = findViewById(R.id.addChair5);

        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add5);
            }
        });

        View add6 = findViewById(R.id.addChair6);

        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add6);
            }
        });
        View add7 = findViewById(R.id.addChair7);

        add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add7);
            }
        });

        View add8 = findViewById(R.id.addChair8);

        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add8);
            }
        });
        View add9 = findViewById(R.id.addChair9);

        add9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add9);
            }
        });

        View add10 = findViewById(R.id.addChair10);

        add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setCartList(add10);
            }
        });
    }
}
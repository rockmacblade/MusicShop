package com.tvastudio.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("Your Order");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userName");
        String goodsName = receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        double goodsPrice = receivedOrderIntent.getDoubleExtra("goodsPrice", 0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0);

        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText("Customer name: "+ userName +"\n"+ "Goods name: " + goodsName +
                               "\n"+ "Quantity: " + quantity +"\n" +"Price: " + goodsPrice + "\n" +
                               "Order Price: " + orderPrice);
    }
}
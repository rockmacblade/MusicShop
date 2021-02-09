 package com.tvastudio.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.nameEditText);

        createSpinner();

        createMap();
    }

    void createSpinner () {
        spinner = findViewById(R.id.spinnerElements);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Ukulele");
        spinnerArrayList.add("Violin");
        spinnerArrayList.add("Piano");
        spinnerArrayList.add("Drums");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap(){
        goodsMap = new HashMap();

        goodsMap.put("Guitar", 500.0);
        goodsMap.put("Ukulele", 200.0);
        goodsMap.put("Violin", 400.0);
        goodsMap.put("Piano", 2000.0);
        goodsMap.put("Drums", 1500.0);
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.textQuantity);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.textOrderPrice);
        priceTextView.setText("" + quantity * price +" $");
    }

    public void decreaseQuantity(View view) {
        quantity = quantity - 1;
        if (quantity < 0){
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.textQuantity);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.textOrderPrice);
        priceTextView.setText("" + quantity * price +" $");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.textOrderPrice);
        priceTextView.setText("" + quantity * price +" $");

        ImageView goodsImageView = findViewById(R.id.imageElement);

        switch (goodsName){
            case "Guitar":
                goodsImageView.setImageResource(R.drawable.eguitar);
                break;
            case "Ukulele":
                goodsImageView.setImageResource(R.drawable.ukulele);
                break;
            case "Violin":
                goodsImageView.setImageResource(R.drawable.violin);
                break;
            case "Piano":
                goodsImageView.setImageResource(R.drawable.piano);
                break;
            case "Drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
        }


        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {

        Order order = new Order();

        order.userName = userNameEditText.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantity;
        order.price = price;
        order.orderPrice = quantity*price;

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userName", order.userName);
        orderIntent.putExtra("goodsName", order.goodsName);
        orderIntent.putExtra("quantity", order.quantity);
        orderIntent.putExtra("goodsPrice", order.price);
        orderIntent.putExtra("orderPrice", order.orderPrice);
        startActivity(orderIntent);
    }
}
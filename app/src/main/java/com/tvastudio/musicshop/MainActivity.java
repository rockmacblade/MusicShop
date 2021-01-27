package com.tvastudio.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerElements);
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

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.textQuantity);
        quantityTextView.setText("" + quantity);
    }

    public void decreaseQuantity(View view) {
        quantity = quantity - 1;
        if (quantity < 0){
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.textQuantity);
        quantityTextView.setText("" + quantity);
    }
}
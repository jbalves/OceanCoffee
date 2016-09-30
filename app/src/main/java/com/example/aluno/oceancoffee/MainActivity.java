package com.example.aluno.oceancoffee;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){

        int price = calculatePrice(quantity,5);
        String summary = createOrderSummary(quantity,price);

        TextView summaryView = (TextView) findViewById(R.id.summaryOrder);

        summaryView.setText(summary);
    }

    public void displayPrice(){

    }

    public void increment(View view){

    }

    public void decrement(View view){

    }

    public void displayQuantity(){

    }

    private String createOrderSummary(int quantity, int price){
        String message = getString(R.string.nome);
        message += getString(R.string.quantidade) + quantity;
        message += getString(R.string.total) + price;
        message += getString(R.string.thanks);
        return message;
    }

    private int calculatePrice(int quantity, int priceByCup){
        return quantity*priceByCup;
    }
}

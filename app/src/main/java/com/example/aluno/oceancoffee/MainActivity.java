package com.example.aluno.oceancoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOreder(){

    }

    public void displayPrice(){

    }
    public void increment(){

    }
    public void decrement(){

    }
    public void displayQuantity(){

    }
    public void createOrderSummary(){

    }
    public int calculatePrice(int quantity, int priceByCup){
        return quantity*priceByCup;

    }
}

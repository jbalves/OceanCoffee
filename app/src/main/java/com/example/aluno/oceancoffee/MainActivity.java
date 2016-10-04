package com.example.aluno.oceancoffee;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private final int PRICE_BY_CUP = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);
    }

    public void submitOrder(View view) {
        CheckBox chocolateView = (CheckBox) findViewById(R.id.chocolate);
        CheckBox cremeView = (CheckBox) findViewById(R.id.whippedCream);

        boolean hasChocolate = chocolateView.isChecked();
        boolean hasCreme = cremeView.isChecked();

        EditText nomeView = (EditText) findViewById(R.id.name);

        String nome = nomeView.getText().toString();

        int price = calculatePrice(quantity, PRICE_BY_CUP, hasChocolate, hasCreme);
        String summary;

        TextView summaryView = (TextView) findViewById(R.id.summaryOrder);


        Firebase myFirebaseRef = new Firebase("https://oceancoffe-5f9d1.firebaseio.com/");



        Log.d("Debug", "O preço é : " + price);




        Log.d("Debug", "Possui chocolate? " + hasChocolate);
        Log.d("Debug", "Possui creme? " + hasCreme);

        summary = createOrderSummary(quantity, price, hasChocolate, hasCreme, nome);
        summaryView.setText(summary);
        myFirebaseRef.child("message").setValue(summary);



    }

    public void displayPrice(){

    }

    public void increment(View view){

    }

    public void decrement(View view){

    }

    public void displayQuantity(){

    }

    private String createOrderSummary(int quantity, int price, boolean hasChocolate, boolean hasCreme, String nome){
        String message = getString(R.string.nome) + nome;
        message += getString(R.string.quantidade) + quantity;
        message += getString(R.string.add_chocolate) + hasChocolate;
        message += getString(R.string.add_creme) + hasCreme;
        message += getString(R.string.total) + price;
        message += getString(R.string.thanks);
        return message;
    }

    private int calculatePrice(int quantity, int priceByCup, boolean hasChocolate, boolean hasCreme){
        int price = priceByCup;

        if (hasChocolate) {
            price +=1;
        }

        if (hasCreme) {
            price +=1;
        }
        price = quantity * price;

        return price;
    }
}

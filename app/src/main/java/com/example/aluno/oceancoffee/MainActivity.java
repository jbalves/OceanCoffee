package com.example.aluno.oceancoffee;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    private static final int MIN_OF_CUP = 1;
    private static final int MAX_OF_CUP = 100;
    private int quantity = 1;
    private final int PRICE_BY_CUP = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        //Enable transitions
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view) {
        Firebase myFirebaseRef = new Firebase("https://oceancoffe-5f9d1.firebaseio.com/");

        CheckBox chocolateView = (CheckBox) findViewById(R.id.chocolate);
        CheckBox cremeView = (CheckBox) findViewById(R.id.whippedCream);

        boolean hasChocolate = chocolateView.isChecked();
        boolean hasCreme = cremeView.isChecked();

        EditText nomeView = (EditText) findViewById(R.id.name);
        String nome = nomeView.getText().toString();
        String summary;
        int price;

        price = calculatePrice(quantity, PRICE_BY_CUP, hasChocolate, hasCreme);

        TextView summaryView = (TextView) findViewById(R.id.summaryOrder);
        summary = createOrderSummary(quantity, price, hasChocolate, hasCreme, nome);
        summaryView.setText(summary);

        myFirebaseRef.child("message").setValue(summary);

        Log.d("Debug", "O preço é : " + price);
        Log.d("Debug", "Possui chocolate? " + hasChocolate);
        Log.d("Debug", "Possui creme? " + hasCreme);

        Intent intent = new Intent(ACTION_VIEW);
        intent.setData(Uri.parse("sms:984474596"));
        intent.putExtra("sms_body", summary);

        if (intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }
    }

    public void displayPrice(){

    }

    public void decrement(View view){
        if (quantity <= MIN_OF_CUP) return;
        quantity--;
        displayQuantity(quantity);
    }

    public void increment(View view){
        if (quantity >= MAX_OF_CUP) return;
        quantity ++;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity){
        TextView quantityView = (TextView) findViewById(R.id.quantity_text_view);
        quantityView.setText(""+ this.quantity);
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

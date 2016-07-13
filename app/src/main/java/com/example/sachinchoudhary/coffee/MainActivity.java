package com.example.sachinchoudhary.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    public void increment(View view){
        quantity++;
        display(quantity);
    }
    public void decrement(View view)
    {
        if(quantity>0)
            quantity--;
        display(quantity);
    }
    public void submitorder(View view)
    {
        String priceMessage="Name:sachin choudhary\n " + "Total: Rs." + quantity*5 + "\n Thank You!";
        orderSummary(priceMessage);
    }
    private void display(int number){
        TextView quantityTextView=(TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void orderSummary(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(message);
    }


}

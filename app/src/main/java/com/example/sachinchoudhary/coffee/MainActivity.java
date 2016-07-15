package com.example.sachinchoudhary.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
    public void onCheckboxClicked(View view){}
    public void submitOrder(View view)
    {
        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        String priceMessage="Name:Sachin Choudhary\n " + " Add whipped cream?" + hasWhippedCream + "\nQuantity:" + quantity + "\nTotal: Rs." + quantity*5 + "\n Thank You!";
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

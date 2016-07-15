package com.example.sachinchoudhary.coffee;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    public void increment(View view){
        if(quantity==100)
        {
            Toast.makeText(this,"You cannot order more than 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }
    public void decrement(View view)
    {
        if(quantity==0)
        {
            Toast.makeText(this,"Too less,isn't it",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }

    public void submitOrder(View view)
    {
        EditText nameField=(EditText) findViewById(R.id.name_field);
        String name=nameField.getText().toString();

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();

        CheckBox choclateCreamCheckBox=(CheckBox) findViewById(R.id.choclate_cream_checkbox);
        boolean hasChoclateCream=choclateCreamCheckBox.isChecked();

        int basePrice=5;
        if(whippedCreamCheckBox.isChecked())
        {
            basePrice+=1;
        }
        if(choclateCreamCheckBox.isChecked())
        {
            basePrice+=2;
        }

        String priceMessage=createOrderSummary(name,hasWhippedCream,hasChoclateCream,basePrice,quantity);
        displayMessage(priceMessage);
    }
    private String createOrderSummary(String nameText,boolean addWhippedCream,boolean addChoclateCream,int basePrice,int quantity){
        String priceMessage="Name:" + nameText;
        priceMessage+="\nadd Whipped Cream ? " + addWhippedCream;
        priceMessage+="\nadd Choclate Cream ? " + addChoclateCream;
        priceMessage+="\nQuantity: " + quantity;
        priceMessage+="\nTotal Rs." + basePrice*quantity;
        priceMessage+="\n Thank you !!";
        return  priceMessage;
    }
    private void display(int number){
        TextView quantityTextView=(TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(message);
    }


}

package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberofOrderedCoffees = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitTheOrder(View view) {
        TextView thanksTextView = findViewById(R.id.thanks_text_view);
        thanksTextView.setText("Thank you!\nTotal:"+numberofOrderedCoffees*5+"dollars"
        +"");
    }

    /**
     * this method is called when the add button is clicked
     */
    public void add(View view) {
        numberofOrderedCoffees++;
        display(numberofOrderedCoffees);
        displayPrice(numberofOrderedCoffees * 5);
    }

    /**
     * this method is called when the minus button is clicked
     */
    public void minus(View view) {
        if (numberofOrderedCoffees > 0) {
            numberofOrderedCoffees--;
            display(numberofOrderedCoffees);
            displayPrice(numberofOrderedCoffees * 5);
        }else{
            return;
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
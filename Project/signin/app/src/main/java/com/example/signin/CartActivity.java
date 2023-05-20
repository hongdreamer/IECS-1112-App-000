package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
  private ListView lvCart;
  private Button btnSendOrder;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart);

    // get
    List<FoodItem> orderItems = Order.getInstance().getOrder();

    lvCart = findViewById(R.id.lv_cart);
    ListViewAdapter4Cart adapter = new ListViewAdapter4Cart(this,orderItems);
    lvCart.setAdapter(adapter);

    // go checking the cart.
    // page switching.
    btnSendOrder = findViewById(R.id.btn_send_order);
    Button.OnClickListener listener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(CartActivity.this, FinishActivity.class);
        startActivity(intent);
      }
    };
    btnSendOrder.setOnClickListener(listener);
  }
}
package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
  private ListView lvCart;
  private Button btnSendOrder, btnCartBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart);

    // get
    List<FoodItem> orderItems = Order.getInstance().getOrder();

    lvCart = findViewById(R.id.lv_cart);
    ListViewAdapter4Cart adapter = new ListViewAdapter4Cart(this,orderItems);
    lvCart.setAdapter(adapter);

    // 设置 ListView 的点击事件监听器
    lvCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 弹出删除确认对话框
        showDeleteConfirmationDialog(position);
      }
    });

    // go checking the cart.
    // page switching.
    btnSendOrder = findViewById(R.id.btn_send_order);
    Button.OnClickListener listener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        Order order = Order.getInstance();
        order.clear();

        Intent intent = new Intent(CartActivity.this, FinishActivity.class);
        startActivity(intent);
        finish();
      }
    };
    btnSendOrder.setOnClickListener(listener);

    btnCartBack = findViewById(R.id.btn_cart_back);
    btnCartBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  private void showDeleteConfirmationDialog(final int position) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("確認刪除")
            .setMessage("確認刪除此項嗎?？")
            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                // 从订单中删除对应的项
                List<FoodItem> orderItems = Order.getInstance().getOrder();
                orderItems.remove(position);

                // 刷新显示
                ListViewAdapter4Cart adapter = (ListViewAdapter4Cart) lvCart.getAdapter();
                adapter.notifyDataSetChanged();
              }
            })
            .setNegativeButton("取消", null)
            .create()
            .show();
  }

  @Override
  public void onBackPressed() {
    // Disable the back button
    // Remove the super call to disable the default back button behavior
    Intent intent = new Intent(CartActivity.this, MenuActivity.class);
    startActivity(intent);
    finish();
  }
}
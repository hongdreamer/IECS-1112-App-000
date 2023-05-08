package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_page extends AppCompatActivity {

    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnOrder = findViewById(R.id.btn_order);
        Button.OnClickListener listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, product_list.class);
                startActivity(intent);
            }
        };
        btnOrder.setOnClickListener(listener);

    }
}
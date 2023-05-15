package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private Button btnOrder, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnOrder = findViewById(R.id.btn_order);
        Button.OnClickListener btnOrderOnClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        };
        btnOrder.setOnClickListener(btnOrderOnClickListener);

        btnLogout = findViewById(R.id.btn_logout);
        Button.OnClickListener btnLogoutOnClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnLogout.setOnClickListener(btnLogoutOnClickListener);



    }
}
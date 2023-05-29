package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private List<FoodItem> ad_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ListView lvAds = findViewById(R.id.lv_ads);
        ad_list = new ArrayList<>();
        ad_list.add(new FoodItem(R.drawable.food1, "可樂", 50, "drink"));
        ad_list.add(new FoodItem(R.drawable.food2, "雞塊", 100, "meal"));
        ad_list.add(new FoodItem(R.drawable.food3, "薯條", 20, "meal"));
        ad_list.add(new FoodItem(R.drawable.food4, "漢堡", 30, "meal"));

        ListViewAdapter4Homepage adapter = new ListViewAdapter4Homepage(this, ad_list);
        lvAds.setAdapter(adapter);

        Button btnOrder = findViewById(R.id.btn_order);
        Button.OnClickListener btnOrderOnClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        };
        btnOrder.setOnClickListener(btnOrderOnClickListener);

        Button btnLogout = findViewById(R.id.btn_logout);
        Button.OnClickListener btnLogoutOnClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        btnLogout.setOnClickListener(btnLogoutOnClickListener);
    }

    @Override
    public void onBackPressed() {
        // Disable the back button
        // Remove the super call to disable the default back button behavior
        Toast.makeText(HomePageActivity.this, "This operation has been disable in this page.", Toast.LENGTH_SHORT).show();
    }
}
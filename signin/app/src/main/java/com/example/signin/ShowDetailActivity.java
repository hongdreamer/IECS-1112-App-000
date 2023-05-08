package com.example.signin;

import static java.util.ResourceBundle.getBundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView titleTxt,feeTxt,descriptionTxt,numberTxt;
    private ImageView plusBtn,minusBtn,foodImage;
    private Button addToCartBtn;
    private Fooditem object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        initView();
        


    }


    private void initView() {
        titleTxt = findViewById(R.id.tv_title);
        feeTxt = findViewById(R.id.tv_price);
        descriptionTxt = findViewById(R.id.tv_description);
        numberTxt = findViewById(R.id.tv_amount);
        plusBtn = findViewById(R.id.iv_btn_plus);
        minusBtn = findViewById(R.id.iv_btn_minus);
        foodImage = findViewById(R.id.iv_foodImage);
        addToCartBtn = findViewById(R.id.btn_add_to_cart);

    }
}
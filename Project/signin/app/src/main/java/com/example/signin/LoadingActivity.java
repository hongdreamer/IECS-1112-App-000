package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 创建一个Intent，将其目标设置为LoginActivity
                Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                startActivity(intent);

                // 关闭LoadingActivity
                finish();
            }
        }, 2000); // 3000毫秒即3秒后执行切换逻辑
    }
}
package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FinishActivity extends AppCompatActivity {
  private Button btnRefresh;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_finish);

    btnRefresh = findViewById(R.id.btn_refresh);
    Button.OnClickListener listener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(FinishActivity.this, HomePageActivity.class);
        startActivity(intent);
      }
    };
    btnRefresh.setOnClickListener(listener);
  }
  @Override
  public void onBackPressed() {
    Toast.makeText(FinishActivity.this, "This operation has been disable in this page.", Toast.LENGTH_SHORT).show();
  }
}
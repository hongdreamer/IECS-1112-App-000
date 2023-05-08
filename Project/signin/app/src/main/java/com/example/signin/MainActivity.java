package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etUsername;
    private EditText etPassword;

    private Button btnSignin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignin = findViewById(R.id.btn_signin);
        btnSignup = findViewById(R.id.btn_signup);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);


        Button.OnClickListener listener = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_signin) {
                    SharedPreferences sharedPref = getSharedPreferences("account", MODE_PRIVATE);
                    String username = sharedPref.getString("username", "");
                    String password = sharedPref.getString("password", "");

                    if(username.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString())){
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "invalid username or password", Toast.LENGTH_SHORT).show();

                    }

                }
                else if (v.getId() == R.id.btn_signup) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
            
        };
        btnSignin.setOnClickListener(listener);
        btnSignup.setOnClickListener(listener);

        //Toast.makeText(this, "Oncreate method is called", Toast.LENGTH_SHORT).show();
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "Onstart method is called", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "Onresume method is called", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this, "Onpause method is called", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "Onstop method is called", Toast.LENGTH_SHORT).show();
//    }



}
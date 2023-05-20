package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText etUsername;
    private EditText etPassword;

    private Button btnSignin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                        Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "invalid username or password", Toast.LENGTH_SHORT).show();

                    }

                }
                else if (v.getId() == R.id.btn_signup) {
                    Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(intent);
                }

            }
            
        };
        btnSignin.setOnClickListener(listener);
        btnSignup.setOnClickListener(listener);

        //Toast.makeText(this, "Oncreate method is called", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(LoginActivity.this, "This operation has been disable in this page.", Toast.LENGTH_SHORT).show();
    }
}
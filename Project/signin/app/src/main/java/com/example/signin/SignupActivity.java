package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignup, btnSignupBack;
    private EditText etUsername, etPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.btn_signup2);
        btnSignupBack = findViewById(R.id.btn_signup_back);
        etUsername = findViewById(R.id.et_signup_username);
        etPassword = findViewById(R.id.et_signup_password);

        sharedPreferences = getSharedPreferences("account", MODE_PRIVATE);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (checkExistingAccount(username)) {
                    Toast.makeText(SignupActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                } else {
                    saveAccount(username, password);
                    Toast.makeText(SignupActivity.this, "Signup successful: " + username + ";" + password, Toast.LENGTH_SHORT).show();
                    goToLogin();
                }
            }
        });

        btnSignupBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private boolean checkExistingAccount(String username) {
        String existingUsername = sharedPreferences.getString("username", "");
        return existingUsername.equals(username);
    }

    private void saveAccount(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    private void goToLogin() {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        goToLogin();
    }
}

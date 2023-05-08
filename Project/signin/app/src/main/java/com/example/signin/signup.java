package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private Button btnSignup;
    private EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.btn_signup2);
        etUsername = findViewById(R.id.et_signup_username);
        etPassword = findViewById(R.id.et_signup_password);

        Button.OnClickListener listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();


                if (username.isEmpty() || password.isEmpty()) {
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("account", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.commit();

                Toast.makeText(signup.this, "Signup succesful " + username + ";" + password, Toast.LENGTH_SHORT).show();
                android.os.SystemClock.sleep(1000);
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnSignup.setOnClickListener(listener);
    }
}
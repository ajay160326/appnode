package com.example.yourapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button registerSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.register_email);
        passwordEditText = findViewById(R.id.register_password);
        confirmPasswordEditText = findViewById(R.id.confirm_password);
        registerSubmitButton = findViewById(R.id.register_submit_button);

        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (validateRegistration(username, email, password, confirmPassword)) {
                    // Redirect to LoginActivity
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Invalid registration details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateRegistration(String username, String email, String password, String confirmPassword) {
        // Check if email ends with gmail.com, passwords match and are not empty
        return !username.isEmpty() && email.endsWith("gmail.com") && !password.isEmpty() && password.equals(confirmPassword);
    }
}

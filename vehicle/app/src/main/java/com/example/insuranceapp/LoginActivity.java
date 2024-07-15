package com.example.insuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private RequestQueue requestQueue;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
    }

    public void login(View view) {
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", emailText);
            jsonObject.put("pass", passwordText);
            Log.d(TAG, "JSON object created: " + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "JSON exception: " + e.getMessage());
        }

        String url = "http://10.0.2.2:3000/login";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("msg");
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                            Log.d(TAG, "Login successful: " + message);

                            // Navigate to InsuranceServicesActivity upon successful login
                            Intent intent = new Intent(LoginActivity.this, InsuranceServicesActivity.class);
                            Log.d(TAG, "Starting InsuranceServicesActivity...");
                            startActivity(intent);
                            Log.d(TAG, "InsuranceServicesActivity started.");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e(TAG, "JSON exception: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e(TAG, "Volley error: " + error.getMessage());
                    }
                }
        );

        Log.d(TAG, "Adding request to request queue...");
        requestQueue.add(jsonObjectRequest);
    }
}
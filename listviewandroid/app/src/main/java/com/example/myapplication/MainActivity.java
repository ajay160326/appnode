package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    EditText myinput;

    public void getData() {
        String url = "https://mobiledevappnode.onrender.com/todo/123";
        RequestQueue rq = Volley.newRequestQueue(this);

        JsonObjectRequest jor = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONObject job = jsonObject.getJSONObject("data");
                    String todoId = (String) job.get("id");
                    String task = (String) job.get("task");

                    tv.setText(todoId + ", " + task);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                tv.setText(volleyError.toString());
            }
        });

        /*StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv.setText(response);
                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.i(TAG, "Error :" + error.toString());
            }
        });*/

        rq.add(jor);
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.mybtn);
        tv = findViewById(R.id.name);
        myinput = findViewById(R.id.myinput);

        btn.setOnClickListener((View v) -> {
            String name =  myinput.getText().toString();
            // Toast.makeText((Context) MainActivity.this, "Name is " + name, Toast.LENGTH_LONG).show();
            // tv.setText(name);

            // getData();

            Intent login = new Intent(MainActivity.this, LoginPage.class);
            startActivity(login);
        });
    }
}
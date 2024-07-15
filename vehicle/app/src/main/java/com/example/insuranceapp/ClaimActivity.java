package com.example.insuranceapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class ClaimActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText description, photoUrl;
    private ImageView capturedImage = findViewById(R.id.capturedImage);
    private RequestQueue requestQueue;
    private Bitmap photoBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim);
        description = findViewById(R.id.description);
        photoUrl = findViewById(R.id.photoUrl);
        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
    }

    public void capturePhoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            photoBitmap = (Bitmap) extras.get("data");
            capturedImage.setImageBitmap(photoBitmap);
            // Upload the photoBitmap to server or convert to Base64 string for uploading
        }
    }

    public void fileClaim(View view) {
        String descriptionText = description.getText().toString();
        String photoUrlText = photoUrl.getText().toString();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId", "YOUR_USER_ID"); // Replace with actual user ID
            jsonObject.put("description", descriptionText);
            jsonObject.put("photoUrl", photoUrlText);
            // Convert photoBitmap to Base64 string and add to jsonObject
            if (photoBitmap != null) {
                String base64Image = ImageUtil.convert(photoBitmap);
                jsonObject.put("photo", base64Image);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String url = "http://10.0.2.2:3000/file-claim";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("msg");
                            Toast.makeText(ClaimActivity.this, message, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ClaimActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
}
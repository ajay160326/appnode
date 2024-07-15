package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logoutButton = findViewById(R.id.logoutButton);

        String[] settingOptions = {
                "Lock Screen", "About Mobile", "Display Settings", "Password Settings",
                "WiFi Connection", "Location", "Storage", "Additional Settings",
                "Software Update", "Help"
        };

        LinearLayout settingsLayout = findViewById(R.id.settingsLayout);

        for (final String option : settingOptions) {
            Button button = new Button(this);
            button.setText(option);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingsActivity.this, SettingDetailActivity.class);
                    intent.putExtra("SETTING_TITLE", option);
                    startActivity(intent);
                }
            });
            settingsLayout.addView(button);
        }

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
package com.example.demoapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_detail);

        String settingTitle = getIntent().getStringExtra("SETTING_TITLE");
        if (settingTitle == null) {
            settingTitle = "Setting";
        }

        TextView titleTextView = findViewById(R.id.settingTitleTextView);
        TextView descriptionTextView = findViewById(R.id.settingDescriptionTextView);

        titleTextView.setText(settingTitle);
        descriptionTextView.setText(getSettingDescription(settingTitle));
    }

    private String getSettingDescription(String settingTitle) {
        switch (settingTitle) {
            case "Lock Screen":
                return "Customize your lock screen appearance and security options.";
            case "About Mobile":
                return "View information about your device, including software version and hardware details.";
            case "Display Settings":
                return "Adjust brightness, color, and other display preferences.";
            case "Password Settings":
                return "Change your password and configure security options.";
            case "WiFi Connection":
                return "Connect to available WiFi networks and manage saved connections.";
            case "Location":
                return "Manage location services and app permissions.";
            case "Storage":
                return "View storage usage and manage your files and apps.";
            case "Additional Settings":
                return "Configure other device settings and preferences.";
            case "Software Update":
                return "Check for and install the latest software updates for your device.";
            case "Help":
                return "Get assistance and answers to common questions about your device.";
            default:
                return "No description available.";
        }
    }
}
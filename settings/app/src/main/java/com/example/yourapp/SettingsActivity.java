package com.example.yourapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private String[] settingsItems = {
            "Lock Screen", "About Mobile", "Help", "Home Screen and Lock Screen Settings",
            "Display Settings", "Password Settings", "Wi-Fi Connection", "Location",
            "Storage", "Additional Settings", "Software Update"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ListView settingsListView = findViewById(R.id.settings_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, settingsItems);
        settingsListView.setAdapter(adapter);

        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open the corresponding settings activity
                String selectedItem = settingsItems[position];
                Intent intent;

                switch (selectedItem) {
                    case "Lock Screen":
                        intent = new Intent(SettingsActivity.this, LockScreenActivity.class);
                        break;
                    case "About Mobile":
                        intent = new Intent(SettingsActivity.this, AboutMobileActivity.class);
                        break;
                    case "Help":
                        intent = new Intent(SettingsActivity.this, HelpActivity.class);
                        break;
                    case "Home Screen and Lock Screen Settings":
                        intent = new Intent(SettingsActivity.this, HomeScreenAndLockScreenSettingsActivity.class);
                        break;
                    case "Display Settings":
                        intent = new Intent(SettingsActivity.this, DisplaySettingsActivity.class);
                        break;
                    case "Password Settings":
                        intent = new Intent(SettingsActivity.this, PasswordSettingsActivity.class);
                        break;
                    case "Wi-Fi Connection":
                        intent = new Intent(SettingsActivity.this, WifiConnectionActivity.class);
                        break;
                    case "Location":
                        intent = new Intent(SettingsActivity.this, LocationActivity.class);
                        break;
                    case "Storage":
                        intent = new Intent(SettingsActivity.this, StorageActivity.class);
                        break;
                    case "Additional Settings":
                        intent = new Intent(SettingsActivity.this, AdditionalSettingsActivity.class);
                        break;
                    case "Software Update":
                        intent = new Intent(SettingsActivity.this, SoftwareUpdateActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
    }
}
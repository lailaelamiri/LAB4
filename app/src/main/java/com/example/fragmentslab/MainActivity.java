package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPlayer, btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect our buttons to the XML layout
        btnPlayer   = findViewById(R.id.btnPlayer);
        btnSettings = findViewById(R.id.btnSettings);

        // Load the Player panel when the app first opens
        if (savedInstanceState == null) {
            switchPanel(new PlayerFragment(), false);
        }

        // When user taps Player button
        btnPlayer.setOnClickListener(v -> switchPanel(new PlayerFragment(), true));

        // When user taps Settings button
        btnSettings.setOnClickListener(v -> switchPanel(new SettingsFragment(), true));
    }

    // Reusable method to swap any fragment into the container
    private void switchPanel(Fragment incomingFragment, boolean canGoBack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, incomingFragment);

        if (canGoBack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
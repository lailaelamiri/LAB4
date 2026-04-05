package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayerFragment extends Fragment {

    private TextView songTitle;
    private Button btnPlayPause;
    private boolean isPlaying = false;

    public PlayerFragment() {
        super(R.layout.fragment_player); // binds layout automatically
    }
    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("PlayerFragment", "▶ onResume — fragment is now visible");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("PlayerFragment", "⏸ onPause — fragment going to background");
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        songTitle  = view.findViewById(R.id.songTitle);
        btnPlayPause = view.findViewById(R.id.btnPlayPause);

        // Toggle play/pause state on each tap
        btnPlayPause.setOnClickListener(v -> {
            if (isPlaying) {
                isPlaying = false;
                btnPlayPause.setText("▶ Play");
                songTitle.setText("⏸ Paused");
            } else {
                isPlaying = true;
                btnPlayPause.setText("⏸ Pause");
                songTitle.setText("🎵 Now Playing: Blinding Lights");
            }
        });
    }
}
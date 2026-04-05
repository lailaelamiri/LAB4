package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    private TextView volumeLabel;
    private SeekBar volumeBar;
    private int currentVolume = 0;
    private static final String KEY_VOLUME = "volume_level";

    public SettingsFragment() {
        super(R.layout.fragment_settings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        volumeLabel = view.findViewById(R.id.volumeLabel);
        volumeBar   = view.findViewById(R.id.volumeBar);

        // Restore volume level if screen was rotated
        if (savedInstanceState != null) {
            currentVolume = savedInstanceState.getInt(KEY_VOLUME, 0);
            volumeBar.setProgress(currentVolume);
            volumeLabel.setText(getVolumeEmoji(currentVolume));
        }

        // Listen to SeekBar changes
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentVolume = progress;
                volumeLabel.setText(getVolumeEmoji(progress));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    // Helper method: returns emoji based on volume level
    private String getVolumeEmoji(int vol) {
        if (vol == 0)       return "🔇 Volume: " + vol;
        else if (vol < 40)  return "🔈 Volume: " + vol;
        else if (vol < 75)  return "🔉 Volume: " + vol;
        else                return "🔊 Volume: " + vol;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_VOLUME, currentVolume);
    }
}
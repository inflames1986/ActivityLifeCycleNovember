package com.inflames1986.activitylifecyclenovember;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_Log2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            log("Fresh Create");
        } else {
            log("Recreate");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        log("Started");
    }

    @Override
    protected void onResume() {
        super.onResume();

        log("Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();

        log("Stopped");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        log("Save instance state");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("Destroyed");
    }

    private void log(String message) {
        Log.d(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
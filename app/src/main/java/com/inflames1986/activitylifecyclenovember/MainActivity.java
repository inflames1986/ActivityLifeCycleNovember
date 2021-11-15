package com.inflames1986.activitylifecyclenovember;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            log("Fresh Create");
        } else {
            log("Recreate");
        }

        findViewById(R.id.hello_world).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
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
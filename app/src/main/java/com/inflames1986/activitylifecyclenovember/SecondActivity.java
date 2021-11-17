package com.inflames1986.activitylifecyclenovember;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.inflames1986.activitylifecyclenovember.domain.Counter;
import com.inflames1986.activitylifecyclenovember.domain.SecondCounter;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_Log2";
    private static final String ARG_COUNTER_VALUE = "ARG_COUNTER_VALUE";
    private static final String ARG_SECOND_COUNTER_VALUE = "ARG_SECOND_COUNTER_VALUE";
    private static final String ARG_THIRD_COUNTER_VALUE = "ARG_THIRD_COUNTER_VALUE";

    private int firstCounterValue = 0;

    private TextView firstCounterResult;
    private TextView secondCounterResult;
    private TextView thirdCounterResult;

    private Counter counter = new Counter();
    private SecondCounter secondCounter = new SecondCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            log("Fresh Create");
            counter = new Counter();
        } else {
            log("Recreate");

            firstCounterValue = savedInstanceState.getInt(ARG_COUNTER_VALUE);

            counter = (Counter) savedInstanceState.getSerializable(ARG_SECOND_COUNTER_VALUE);
            secondCounter = (SecondCounter) savedInstanceState.getParcelable(ARG_THIRD_COUNTER_VALUE);
        }

        findViewById(R.id.increase_btn).setOnClickListener(v -> {
            firstCounterValue++;
            SecondActivity.this.updateCounter();
        });

        findViewById(R.id.increase_second_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.increase();
                updateSecondCounter();
            }
        });

        findViewById(R.id.increase_third_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondCounter.increase();
                updateThirdCounter();
            }
        });

        firstCounterResult = findViewById(R.id.counter_textview);

        secondCounterResult = findViewById(R.id.counter_second_textview);

        thirdCounterResult = findViewById(R.id.counter_third_textview);

        updateCounter();

        updateSecondCounter();

        updateThirdCounter();

    }

    private void updateCounter() {
        firstCounterResult.setText(String.valueOf(firstCounterValue));
    }

    private void updateSecondCounter() {
        secondCounterResult.setText(String.valueOf(counter.getValue()));
    }

    private void updateThirdCounter() {
        thirdCounterResult.setText(String.valueOf(secondCounter.getValue()));
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

        outState.putInt(ARG_COUNTER_VALUE, firstCounterValue);
        outState.putSerializable(ARG_SECOND_COUNTER_VALUE, counter);
        outState.putParcelable(ARG_THIRD_COUNTER_VALUE, secondCounter);
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
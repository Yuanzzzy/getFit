package com.example.liyuanzzzy.getfit;

import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.util.Locale;

public abstract class CountTimer extends AppCompatActivity {
    private static final long workOutTime = 60_000; // 1min

    private TextView countdownMsg;
    private Button countdownButton,pauseButton, resetButton;
    TextView timeSet;

    private CountDownTimer countdownTimer;
    private long timeLeftInMiliSec = workOutTime; // 1min
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_timer);

        //time received from the setTime page
        timeSet = (TextView)findViewById(R.id.editTime);

        //variable IDs
        countdownMsg = findViewById(R.id.Time_remaining);

        countdownButton = findViewById(R.id.button_start);
        pauseButton = findViewById(R.id.button_timer_pause);
        resetButton = findViewById(R.id.button_reset);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer() {
        countdownTimer = new CountDownTimer(timeLeftInMiliSec, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliSec = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                pauseButton.setText("START");
                pauseButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.VISIBLE);
            }
        }.start();

        timerRunning = true;
        pauseButton.setText("PAUSE");
        resetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        countdownTimer.cancel();
        timerRunning = false;
        pauseButton.setText("START");
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMiliSec = workOutTime;
        updateCountDownText();
        resetButton.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMiliSec / 1000) / 60;
        int seconds = (int) (timeLeftInMiliSec / 1000) % 60; // sec left

        String timerLeftFormattd = String.format(Locale.getDefault(), "%02:%02", minutes, seconds);
        countdownMsg.setText(timerLeftFormattd);
    }
}

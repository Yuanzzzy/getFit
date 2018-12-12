package com.example.liyuanzzzy.getfit;

import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.Locale;

public abstract class CountTimer extends AppCompatActivity {
//    private static final long workOutTime = 60_000; // 1min
//
//    private TextView countdownMsg;
//    private Button countdownButton,pauseButton, resetButton;
//    TextView timeSet;
//
//    private CountDownTimer countdownTimer;
//    private long timeLeftInMiliSec = workOutTime; // 1min
//    private boolean timerRunning;

    //Chronometer timer = (Chronometer) findViewById(R.id.timer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_timer);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();

        GenerateWorkout workout = new GenerateWorkout();

        ArrayList<String> selection = extras.getStringArrayList("muscle");

        int time = Integer.parseInt(extras.getString("timer"));
        ArrayList<Exercise> finalWorkout = workout.generate(time, selection);

//        TextView tvName = (TextView) findViewById(R.id.textView5);
//        if (extras != null){
//            tvName.setText("YOUR WORKOUT TOTAL TIME: " + extras.getString("timer") + " MIN");
//        }

        TextView wrklist = (TextView)findViewById(R.id.Exercise_name);
        for (int i = 0; i < finalWorkout.size(); i++) {
            wrklist.setText(wrklist.getText() + finalWorkout.get(i).name + "  1 MINUTE\n" + "30 Sec Break\n");
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        final Button endButton = findViewById(R.id.button_endExercise);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        startActivity(new Intent(CountTimer.this, EndScreen.class));
            }
        });
    }
}


//    public void btnClick(View view) {
//        timer.setBase(SystemClock.elapsedRealtime());
//        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
//        timer.setFormat("0" + String.valueOf(hour) + ":%s");
//        timer.start();
//    }
//
//    public void stopClick(View view) {
//        timer.stop();
//    }
//
//    public void onClick(View view) {
//        Intent i = new Intent(CountTimer.this, EndScreen.class);
//        finish();  //Kill the activity from which you will go to next activity
//        startActivity(i);
//    }
//}
//
//        //time received from the setTime page
//        timeSet = (TextView)findViewById(R.id.editTime);
//
//        //variable IDs
//        countdownMsg = findViewById(R.id.Time_remaining);
//
//        countdownButton = findViewById(R.id.button_start);
//        pauseButton = findViewById(R.id.button_timer_pause);
//        resetButton = findViewById(R.id.button_reset);
//
//        countdownButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (timerRunning) {
//                    pauseTimer();
//                } else {
//                    startTimer();
//                }
//            }
//        });
//
//        resetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resetTimer();
//            }
//        });
//        updateCountDownText();
//    }
//
//    private void startTimer() {
//        countdownTimer = new CountDownTimer(timeLeftInMiliSec, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeLeftInMiliSec = millisUntilFinished;
//                updateCountDownText();
//            }
//
//            @Override
//            public void onFinish() {
//                timerRunning = false;
//                pauseButton.setText("START");
//                pauseButton.setVisibility(View.INVISIBLE);
//                resetButton.setVisibility(View.VISIBLE);
//            }
//        }.start();
//
//        timerRunning = true;
//        pauseButton.setText("PAUSE");
//        resetButton.setVisibility(View.INVISIBLE);
//    }
//
//    private void pauseTimer() {
//        countdownTimer.cancel();
//        timerRunning = false;
//        pauseButton.setText("START");
//        resetButton.setVisibility(View.VISIBLE);
//    }
//
//    private void resetTimer() {
//        timeLeftInMiliSec = workOutTime;
//        updateCountDownText();
//        resetButton.setVisibility(View.INVISIBLE);
//        pauseButton.setVisibility(View.VISIBLE);
//    }
//
//    private void updateCountDownText() {
//        int minutes = (int) (timeLeftInMiliSec / 1000) / 60;
//        int seconds = (int) (timeLeftInMiliSec / 1000) % 60; // sec left
//
//        String timerLeftFormattd = String.format(Locale.getDefault(), "%02:%02", minutes, seconds);
//        countdownMsg.setText(timerLeftFormattd);
//    }


package com.example.liyuanzzzy.getfit;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import android.os.Handler;
import java.util.List;
import java.util.Timer;

public class UserWorkout extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart, btnRegenerate, btnComplete;
    private Timer timer;
    private boolean change;
    private ArrayList<Exercise> finalWorkout;
    private TextView wrklist;
    private int userTime;
    private TextView wrkItem;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_workout);
        btnStart = findViewById(R.id.button_start);
        btnRegenerate = findViewById(R.id.button2_regenerate);
        btnComplete = findViewById(R.id.button_complete);
        //set up OnClickListeners
        btnStart.setOnClickListener(this);
        btnRegenerate.setOnClickListener(this);
        btnComplete.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        userTime = Integer.parseInt(extras.getString("timer"));
        wrkItem = findViewById(R.id.Item_name);
        display(); //to display the list
    }

    /**
     * method to display the list.
     */
    public void display() {
        GenerateWorkout workout = new GenerateWorkout();
        Bundle extras = getIntent().getExtras();
        ArrayList<String> selection = extras.getStringArrayList("muscle");
        finalWorkout = workout.generate(userTime, selection);
        TextView tvName = findViewById(R.id.textView5);
        if (extras != null){
            tvName.setText("YOUR WORKOUT TOTAL TIME: " + extras.getString("timer") + " MIN");
        }
        wrklist = findViewById(R.id.workOut_list);
        wrklist.setMovementMethod(new ScrollingMovementMethod());
        for (int i = 0; i < finalWorkout.size(); i++) {
            wrklist.setText(wrklist.getText() + finalWorkout.get(i).name + "  1 min.\n" + "30 sec. break\n");
        }
    }


//    private void set() {
//        final Handler handler = new Handler();
//        final ArrayList<Exercise> workoutLst = new ArrayList<>(finalWorkout);
//        btnComplete.setVisibility(View.VISIBLE);
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                wrkItem.setText(wrkItem.getText() + finalWorkout.get(i).name);
//                i++;
//                wrkItem.setText(" ");
//                if (i < workoutLst.size()) {
//                    handler.postDelayed(this, 60000);
//                }
//            }
//        });
//    }

//    public void countDown() {
//        //time = (long) userTime /
//        wrklist.setVisibility(View.GONE);
//        wrkItem.setVisibility(View.VISIBLE);
//        countDownTimer = new CountDownTimer(60000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                wrkItem.setText("seconds remaining: " + millisUntilFinished / 1000);
//            }
//
//            @Override
//            public void onFinish() {
//                btnComplete.setVisibility(View.VISIBLE);
//                finish();
//            }
//        }.start();
//    }

//    public void timer(long time) {
//        wrklist.setVisibility(View.GONE);
//        wrkItem.setVisibility(View.VISIBLE);
//        new CountDownTimer(time, 1000) {
//            @Override
//            public void onTick(long millis) {
//                btnComplete.setVisibility(View.VISIBLE);
//                wrkItem.setText("Time remaininng: \n" + (int) millis / 1000);
//            }
//
//            @Override
//            public void onFinish() {
//                finish();
//            }
//        }.start();
//    }

//    public void breakTimer(long time) {
//        wrklist.setVisibility(View.GONE);
//        wrkItem.setVisibility(View.VISIBLE);
//        new CountDownTimer(time, 1000) {
//            @Override
//            public void onTick(long millis) {
//                wrkItem.setText("Break: \n" + (int) millis / 1000);
//            }
//
//            @Override
//            public void onFinish() {
//                finish();
//            }
//        }.start();
//    }

    /**
     * button control
     * @param v button id.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                //ArrayList<Exercise> workoutLst = new ArrayList<>(finalWorkout);
                btnStart.setVisibility(View.INVISIBLE);
                btnComplete.setVisibility(View.VISIBLE);
//                for (int item = 0; item < workoutLst.size(); item++) {
//                    timer(600000);
//                }
            case R.id.button2_regenerate:
                wrklist.setText(" ");
                display();
                break;
            case R.id.button_complete:
                Intent i = new Intent(UserWorkout.this, EndScreen.class);
                startActivity(i);
                break;
        }
    }
}
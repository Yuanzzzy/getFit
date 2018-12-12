package com.example.liyuanzzzy.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ListView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UserWorkout extends AppCompatActivity implements View.OnClickListener {
    Button btnStart, btnRegenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_workout);
        btnStart = findViewById(R.id.button_start);
        btnRegenerate = findViewById(R.id.button2_regenerate);
        //set up OnClickListeners
        btnStart.setOnClickListener(this);
        btnRegenerate.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();

        GenerateWorkout workout = new GenerateWorkout();

        ArrayList<String> selection = extras.getStringArrayList("muscle");

        int time = Integer.parseInt(extras.getString("timer"));
        ArrayList<Exercise> finalWorkout = workout.generate(time, selection);

        TextView tvName = (TextView) findViewById(R.id.textView5);
        if (extras != null){
            tvName.setText("YOUR WORKOUT TOTAL TIME: " + extras.getString("timer") + " MIN");
        }

//        ArrayAdapter<String> adapter;
//        String[] items = {"1", "2", "3"};
//        adapter = new ArrayAdapter<String>(this, R.layout.activity_user_workout, items);
//        ListView displayWorkout = (ListView) findViewById(R.id.workOut_list_content);
////        displayWorkout.setAdapter(adapter);
//
//
//        displayWorkout.setAdapter(adapter);
        TextView wrklist = (TextView)findViewById(R.id.workOut_list);
        for (int i = 0; i < finalWorkout.size(); i++) {
            wrklist.setText(wrklist.getText() + finalWorkout.get(i).name + "  1 min.\n" + "30 sec. break\n");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                Intent i = new Intent(UserWorkout.this, EndScreen.class);
                startActivity(i);
                break;
            case R.id.button2_regenerate:
                i = new Intent(UserWorkout.this, MuscleSelection.class);
                startActivity(i);
                break;
        }
    }
}


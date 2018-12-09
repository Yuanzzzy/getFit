package com.example.liyuanzzzy.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetTime extends AppCompatActivity {
    Button btnMove; //button to next activity
    //EditText editTime; //time for workout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);


        btnMove = (Button)findViewById(R.id.btn_move);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTime = findViewById(R.id.editTime);
                String timeInput = editTime.getText().toString();
                Intent i = new Intent(SetTime.this, MuscleSelection.class);
                i.putExtra("timer", timeInput);
                startActivity(i);
            }
        });
    }
}

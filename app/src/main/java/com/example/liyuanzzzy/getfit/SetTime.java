package com.example.liyuanzzzy.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetTime extends AppCompatActivity {
Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        btnMove = (Button)findViewById(R.id.btn_move);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SetTime.this, MuscleSelection.class);
                startActivity(i);
            }
        });
    }
}

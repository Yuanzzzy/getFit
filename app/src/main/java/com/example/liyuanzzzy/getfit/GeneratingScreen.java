package com.example.liyuanzzzy.getfit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import java.util.ArrayList;

public class GeneratingScreen extends AppCompatActivity {
    private static int generateInterval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO auto-generated method stub
                Intent i = new Intent(GeneratingScreen.this, UserWorkout.class);
                Bundle extras = getIntent().getExtras();
                String timer = extras.getString("timer");
                i.putExtra("timer", timer);
                ArrayList<String> selection = extras.getStringArrayList("muscle");
                i.putExtra("muscle", selection);

                startActivity(i);

                this.finish();
            }
            private void finish() {
            }
        }, generateInterval);
    };
}

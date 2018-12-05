package com.example.liyuanzzzy.getfit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class GeneratingScreen extends AppCompatActivity {
    private static int generateInterval = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO auto-generated method stub
                Intent i = new Intent(GeneratingScreen.this, ListView.class);
                startActivity(i);

                this.finish();
            }
            private void finish() {

            }
        }, generateInterval);
    };
}

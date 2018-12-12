package com.example.liyuanzzzy.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndScreen extends AppCompatActivity implements View.OnClickListener {
    Button goAgain, treatYrself;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        goAgain = findViewById(R.id.button_goagain);
        treatYrself = findViewById(R.id.button_treatYourself);
        //set up OnClickListeners
        goAgain.setOnClickListener(this);
        treatYrself.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_goagain:
                Intent i = new Intent(EndScreen.this, SetTime.class);
                startActivity(i);
                break;
            case R.id.button_treatYourself:
                i = new Intent(EndScreen.this, LastPage.class);
                startActivity(i);
                break;
        }
    }
}

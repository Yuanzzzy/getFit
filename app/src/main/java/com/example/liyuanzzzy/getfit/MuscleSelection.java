package com.example.liyuanzzzy.getfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MuscleSelection extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<>();
    //CheckBox A, B, C, D, E, F, G;
//    Button Generate;
//    Integers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_selection);
    }
    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if(checked) {
                    selection.add("Abs");
                } else {
                    selection.remove("Abs");
                }
                break;
            case R.id.checkBox2:
                if(checked) {
                    selection.add("Quads");
                } else {
                    selection.remove("Quads");
                }
                break;
            case R.id.checkBox3:
                if(checked) {
                    selection.add("Chest");
                } else {
                    selection.remove("Chest");
                }
                break;
            case R.id.checkBox4:
                if(checked) {
                    selection.add("Biceps");
                } else {
                    selection.remove("Biceps");
                }
                break;
            case R.id.checkBox5:
                if(checked) {
                    selection.add("Back");
                } else {
                    selection.remove("Back");
                }
                break;
            case R.id.checkBox6:
                if(checked) {
                    selection.add("Glutes");
                } else {
                    selection.remove("Glutes");
                }
                break;
            case R.id.checkBox7:
                if(checked) {
                    selection.add("Triceps");
                } else {
                    selection.remove("Triceps");
                }
                break;
        }


//    public void finalSelection(View view) {
//        String final_muscles = "";
//        for (String muscles : selection) {
//            final_muscles = final_muscles + muscles;
//        }
//
//    }

        Button generatingBut = (Button)findViewById(R.id.button_generate);
        generatingBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MuscleSelection.this, GeneratingScreen.class);
                startActivity(i);

            }
        });
    }
}

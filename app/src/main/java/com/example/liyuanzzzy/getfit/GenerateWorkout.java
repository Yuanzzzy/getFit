package com.example.liyuanzzzy.getfit;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;






public class GenerateWorkout {
    public static ArrayList<Exercise> generate(int duration, ArrayList<String> muscles) {
        ArrayList<Exercise> potentialExercises = new ArrayList<Exercise>();
        ArrayList<Exercise> allExercises = Exercise.getAllExercises();
        for (int i = 0; i < allExercises.size(); i++) {

            Exercise exercise = allExercises.get(i);
            for (int j = 0; j < muscles.size(); j++) {
                if (exercise.muscle.equals(muscles.get(j))) {
                    potentialExercises.add(exercise);
                }
            }
        }
        return potentialExercises;
    }


    public static void main(String[] unused) {
        ArrayList<String> muscleArray = new ArrayList<String>();
        muscleArray.add("Back");
        muscleArray.add("Biceps");
        muscleArray.add("Abs");
        int freeTime = 30;
        ArrayList<Exercise> testArr = generate(freeTime, muscleArray);
        for(int i = 0; i < testArr.size(); i++) {
            System.out.println(testArr.get(i).name);
        }
    }
}




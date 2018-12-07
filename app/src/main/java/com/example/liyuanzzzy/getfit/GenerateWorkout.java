package com.example.liyuanzzzy.getfit;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


/**
 * Class that contains functions for generating workouts with given duration and muscle groups.
 */
public class GenerateWorkout {
    /**
     * Actual functiont hat generates the workout as an array.
     * @param duration int duration of workout in minutes.
     * @param muscles string array of muscles that individual wants to train.
     * @return ArrayList of exercises to perform over given amount of time.
     */
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
        ArrayList<Exercise> finalWorkout = new ArrayList<Exercise>();
        double exerciseCount = duration/1.5;
        int exerciseNum = (int) java.lang.Math.ceil(exerciseCount);
        for (int i = 0; i < exerciseNum; i++) {
            finalWorkout.add(potentialExercises.get(randInt(0, potentialExercises.size())));
        }
        return finalWorkout;
    }

    /**
     * Helper function to generate a random integer between two values.
     * @param min minimum bound for random integer.
     * @param max maximum bound for random integer.
     * @return random integer between min and max.
     */
    private static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) - min;

        return randomNum;
    }


    public static void main(String[] unused) {
        ArrayList<String> muscleArray = new ArrayList<String>();
        muscleArray.add("Biceps");
        muscleArray.add("Abs");
        muscleArray.add("Back");
        int freeTime = 30;
        ArrayList<Exercise> testArr = generate(freeTime, muscleArray);
        for(int i = 0; i < testArr.size(); i++) {
            System.out.println(testArr.get(i).name);
        }
    }
}




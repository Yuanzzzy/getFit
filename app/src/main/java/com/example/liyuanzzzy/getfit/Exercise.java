package com.example.liyuanzzzy.getfit;
import java.util.List;
import java.util.ArrayList;

public class Exercise {
    public String name;
    public String muscle;
    Exercise(String setName, String setMuscle) {
        this.name = setName;
        this.muscle = setMuscle;
    }

    public static ArrayList<Exercise> getAllExercises() {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Push-Ups", "Chest"));
        exercises.add(new Exercise("Plank Rotations", "Chest"));
        exercises.add(new Exercise("Chest Squeezes", "Chest"));
        exercises.add(new Exercise("Shoulder Press", "Chest"));
        exercises.add(new Exercise("Shoulder Taps", "Chest"));
        exercises.add(new Exercise("Clapping Push-Ups", "Chest"));
        exercises.add(new Exercise("Pull-Ups", "Back"));
        exercises.add(new Exercise("Elbow Lifts", "Back"));
        exercises.add(new Exercise("Supermans", "Back"));
        exercises.add(new Exercise("Stair Plank", "Back"));
        exercises.add(new Exercise("Alt-Arm/Leg Plank", "Back"));
        exercises.add(new Exercise("Full Arch", "Back"));
        exercises.add(new Exercise("Leg Curls", "Biceps"));
        exercises.add(new Exercise("Chin-Ups", "Biceps"));
        exercises.add(new Exercise("Doorframe Rows", "Biceps"));
        exercises.add(new Exercise("Body Rows", "Biceps"));
        exercises.add(new Exercise("Sitting Pull-Ups", "Biceps"));
        exercises.add(new Exercise("Pseudo Planche", "Biceps"));
        exercises.add(new Exercise("Close Grip Push-Ups", "Triceps"));
        exercises.add(new Exercise("Tricep Dips", "Triceps"));
        exercises.add(new Exercise("Tricep Extensions", "Triceps"));
        exercises.add(new Exercise("Get-Ups", "Triceps"));
        exercises.add(new Exercise("Punches", "Triceps"));
        exercises.add(new Exercise("Close Grip Push-Ups", "Triceps"));
        exercises.add(new Exercise("Side-to-Side Chops", "Triceps"));
        exercises.add(new Exercise("Squats", "Glutes"));
        exercises.add(new Exercise("Donkey Kick", "Glutes"));
        exercises.add(new Exercise("Bridges", "Glutes"));
        exercises.add(new Exercise("Jump Knee Kicks", "Glutes"));
        exercises.add(new Exercise("Fly Steps", "Glutes"));
        exercises.add(new Exercise("Side Leg Raises", "Glutes"));
        exercises.add(new Exercise("Lunges", "Quads"));
        exercises.add(new Exercise("High Knees Running", "Quads"));
        exercises.add(new Exercise("Turning Kick", "Quads"));
        exercises.add(new Exercise("Climbers", "Quads"));
        exercises.add(new Exercise("Plank Jump-Ins", "Quads"));
        exercises.add(new Exercise("Lunges + Step-Ups", "Quads"));
        exercises.add(new Exercise("Sit-Ups", "Abs"));
        exercises.add(new Exercise("Reverse Crunches", "Abs"));
        exercises.add(new Exercise("Bicycle Crunches", "Abs"));
        exercises.add(new Exercise("Flutter Kicks", "Abs"));
        exercises.add(new Exercise("Leg Raises", "Abs"));
        exercises.add(new Exercise("Elbow Planks", "Abs"));



        return exercises;


    }


}





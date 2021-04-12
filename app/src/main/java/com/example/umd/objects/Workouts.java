package com.example.umd.objects;

import java.util.Date;

public class Workouts {

    private String name;
    private int exerciseDuration;
    private String exerciseType;
    private int exerciseSets;
    private int exerciseReps;
    private int exerciseWeight;
    private Date exerciseDate;

    public Workouts() {
    }

    public Workouts(String name, int exerciseDuration, String exerciseType, int exerciseSets, int exerciseReps, int exerciseWeight, Date exerciseDate) {
        this.name = name;
        this.exerciseDuration = exerciseDuration;
        this.exerciseType = exerciseType;
        this.exerciseSets = exerciseSets;
        this.exerciseReps = exerciseReps;
        this.exerciseWeight = exerciseWeight;
        this.exerciseDate = exerciseDate;
    }

    public String getUName() {
        return name;
    }

    public void setUname(String name) {
        this.name = name;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }
    
    public int getExerciseDuration() { return exerciseDuration; }
    public void setExerciseDuration(int duration){
        this.exerciseDuration = exerciseDuration;
    }
    public int getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(int exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public int getExerciseReps() {
        return exerciseReps;
    }

    public void setExerciseReps(int exerciseReps) {
        this.exerciseReps = exerciseReps;
    }
    public int getExerciseWeight() {
        return exerciseWeight;
    }

    public void setExerciseWeight(int exerciseWeight) {
        this.exerciseWeight = exerciseWeight;
    }

    public Date getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(Date exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

}


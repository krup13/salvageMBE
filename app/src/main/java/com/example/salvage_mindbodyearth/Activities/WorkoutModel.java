package com.example.salvage_mindbodyearth.Activities;

import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutDAO;

public class WorkoutModel {

    private WorkoutDAO workoutDAO;
    private String workoutName;
    private String workoutType;
    private int workoutSets;
    private int workoutReps;

    public WorkoutModel(String workoutName,
                        int workoutReps,
                        int workoutSets,
                        String workoutType) {
        this.workoutName = workoutName;
        this.workoutReps = workoutReps;
        this.workoutSets = workoutSets;
        this.workoutType = workoutType;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public int getWorkoutReps() {
        return workoutReps;
    }

    public int getWorkoutSets() {
        return workoutSets;
    }

    public String getWorkoutType() {
        return workoutType;
    }
}

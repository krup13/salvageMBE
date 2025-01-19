package com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class WorkoutPlanWithWorkouts {
    @Embedded
    public WorkoutPlan workoutPlan;

    @Relation(
            parentColumn = "workout_plan_id",
            entityColumn = "workout_id"
    )
    public List<Workout> workouts;
}

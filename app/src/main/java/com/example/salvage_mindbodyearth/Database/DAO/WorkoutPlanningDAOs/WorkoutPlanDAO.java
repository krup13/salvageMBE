package com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.Workout;
import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.WorkoutPlan;
import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.WorkoutPlanWithWorkouts;

import java.util.List;

@Dao
public interface WorkoutPlanDAO {
    @Insert
    void insertWorkoutPlan(WorkoutPlan workoutPlan);

    @Update
    void updateWorkoutPlan(WorkoutPlan workoutPlan);

    @Delete
    void deleteWorkoutPlan(WorkoutPlan workoutPlan);

    @Query("SELECT * FROM WorkoutPlan")
    List<WorkoutPlan> allWorkoutPlans();

    @Transaction
    @Query("SELECT * FROM WorkoutPlan")
    public List<WorkoutPlanWithWorkouts> getWorkoutPlansWithWorkouts();

    @Transaction
    @Query("SELECT * FROM Workout WHERE workout_id = :id LIMIT 1")
    Workout getWorkoutByWorkoutPlanId(int id);
}

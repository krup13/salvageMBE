package com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.Workout;

import java.util.List;

@Dao
public interface WorkoutDAO {
    @Insert
    void insertWorkout(Workout workout);

    @Update
    void updateWorkout(Workout workout);

    @Delete
    void deleteWorkout(Workout workout);

    @Query("SELECT * FROM Workout")
    List<Workout> getAllWorkouts();

    @Query("SELECT * FROM Workout WHERE workout_id = :id")
    Workout getWorkoutById(int id);

    @Query("SELECT * FROM Workout WHERE workoutName = :workoutName")
    Workout getWorkoutByName(String workoutName);
}

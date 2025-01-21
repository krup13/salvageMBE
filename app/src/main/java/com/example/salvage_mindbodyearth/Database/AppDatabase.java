package com.example.salvage_mindbodyearth.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutDAO;
import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutPlanDAO;
import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.Workout;
import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.WorkoutPlan;

@Database(entities = {Workout.class, WorkoutPlan.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DbConfig.ROOM_DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WorkoutPlanDAO workoutPlanDAO();
    public abstract WorkoutDAO workoutDAO();

}
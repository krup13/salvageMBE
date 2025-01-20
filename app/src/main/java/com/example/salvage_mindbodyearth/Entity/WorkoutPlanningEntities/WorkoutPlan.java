package com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.salvage_mindbodyearth.Database.AppDatabase;
import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutPlanDAO;

import java.util.List;

@Entity
public class WorkoutPlan {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "workout_plan_id")
    private Long id;

    public WorkoutPlan(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

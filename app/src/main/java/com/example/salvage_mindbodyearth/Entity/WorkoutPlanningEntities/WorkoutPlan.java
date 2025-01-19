package com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WorkoutPlan {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "workout_plan_id")
    private long id;

    public WorkoutPlan(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

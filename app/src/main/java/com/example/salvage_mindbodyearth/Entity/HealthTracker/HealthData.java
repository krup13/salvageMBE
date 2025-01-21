package com.example.salvage_mindbodyearth.Entity.HealthTracker;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;

@Entity
public class HealthData {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;
//    private SimpleDateFormat date;
    private int blood_pressure;
    private int heart_rate;
    private double weight;

    public HealthData(double weight, int heart_rate, int blood_pressure, long id) {
        this.weight = weight;
        this.heart_rate = heart_rate;
        this.blood_pressure = blood_pressure;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }

    public int getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(int blood_pressure) {
        this.blood_pressure = blood_pressure;
    }
}

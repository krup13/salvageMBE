package com.example.salvage_mindbodyearth.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.salvage_mindbodyearth.Database.AppDatabase;
import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutDAO;
import com.example.salvage_mindbodyearth.Database.DAO.WorkoutPlanningDAOs.WorkoutPlanDAO;
import com.example.salvage_mindbodyearth.Entity.WorkoutPlanningEntities.Workout;
import com.example.salvage_mindbodyearth.R;
import com.example.salvage_mindbodyearth.Utils.WorkoutListAdapter;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanningActivity extends AppCompatActivity {
    private EditText workoutName;
    private EditText workoutType;
    private EditText workoutSets;
    private EditText workoutReps;
    private RecyclerView recyclerView;
    private WorkoutListAdapter adapter;
    private WorkoutDAO workoutDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planning);

        // Initialize EditTexts
        workoutName = findViewById(R.id.etWorkoutName);
        workoutType = findViewById(R.id.etWorkoutTypes);
        workoutSets = findViewById(R.id.etWorkoutSet);
        workoutReps = findViewById(R.id.etWorkoutReps);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.workout_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Database
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "workout-database").build();
        workoutDAO = db.workoutDAO();

        // Set up the adapter with empty list initially
        adapter = new WorkoutListAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Add swipe-to-delete functionality
        setupSwipeToDelete();

        // Load workouts
        loadWorkouts();

        // Set up Add Workout button
        findViewById(R.id.add_workout_button).setOnClickListener(v -> saveWorkout());
    }

    private void loadWorkouts() {
        // Since Room doesn't allow database operations on the main thread,
        // we need to use a background thread
        new Thread(() -> {
            List<Workout> workouts = workoutDAO.getAllWorkouts();
            runOnUiThread(() -> {
                adapter = new WorkoutListAdapter(new ArrayList<>(workouts));
                recyclerView.setAdapter(adapter);
            });
        }).start();
    }

    public void saveWorkout() {
        String name = workoutName.getText().toString();
        String type = workoutType.getText().toString();
        int sets = Integer.parseInt(workoutSets.getText().toString());
        int reps = Integer.parseInt(workoutReps.getText().toString());

        Workout workout = new Workout();
        workout.setWorkoutName(name);
        workout.setType(type);
        workout.setSets(sets);
        workout.setReps(reps);

        new Thread(() -> {
            workoutDAO.insertWorkout(workout);
            runOnUiThread(() -> {
                clearInputFields();
                loadWorkouts(); // Reload the list after adding
            });
        }).start();
    }

    private void clearInputFields() {
        workoutName.setText("");
        workoutType.setText("");
        workoutSets.setText("");
        workoutReps.setText("");
    }

    private void setupSwipeToDelete() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Workout workoutToDelete = adapter.getWorkoutAt(position);

                // Delete from database in background thread
                new Thread(() -> {
                    workoutDAO.deleteWorkout(workoutToDelete);
                    runOnUiThread(() -> {
                        adapter.removeItem(position);
                    });
                }).start();
            }
        }).attachToRecyclerView(recyclerView);
    }


}
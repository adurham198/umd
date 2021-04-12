package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.umd.objects.Uname;
import com.example.umd.objects.Workouts;

import java.util.Date;

public class DailyWorkoutScreen extends MainActivity{
    Intent dailyWorkoutScreen;
    Intent homeScreen;
    Button a_btn_AddWorkout;
    EditText a_Duration;
    EditText a_Type;
    EditText a_Sets;
    EditText a_Reps;
    EditText a_Weight;
    Date currDate;
    MainActivity ma;
    SQLiteDatabaseHandler dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_workout);
        a_btn_AddWorkout = (Button) findViewById(R.id.button2);
        a_Duration = (EditText) findViewById(R.id.ExerciseDuration);
        a_Type = (EditText) findViewById(R.id.ExerciseType);
        a_Sets = (EditText) findViewById(R.id.ExerciseSets);
        a_Reps = (EditText) findViewById(R.id.ExerciseReps);
        a_Weight= (EditText) findViewById(R.id.ExerciseWeight);

        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        homeScreen = new Intent(this, HomeScreen.class);
        dbhelper = new SQLiteDatabaseHandler(this);
        insertWorkout();
    }
    public void insertWorkout() {

        a_btn_AddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWorkout();
                startActivity(HomeScreen);
            }
        });
    }

    public void addWorkout()
    {
        ma.dbhelper = new SQLiteDatabaseHandler(this);
        Workouts workouts = new Workouts();

        int duration = Integer.parseInt(a_Duration.getText().toString());
        String type = a_Type.getText().toString();
        int sets = Integer.parseInt(a_Sets.getText().toString());
        int reps = Integer.parseInt(a_Reps.getText().toString());
        int weight = Integer.parseInt(a_Weight.getText().toString());
        Date date = new Date();
        workouts.setUname(Uname.username);
        workouts.setExerciseDuration(duration);
        workouts.setExerciseType(type);
        workouts.setExerciseSets(sets);
        workouts.setExerciseReps(reps);
        workouts.setExerciseWeight(weight);
        workouts.setExerciseDate(new Date());
        ma.dbhelper.addWorkout(workouts);
    }
}

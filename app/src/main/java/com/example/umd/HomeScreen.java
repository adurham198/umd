package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.umd.objects.Player;
import com.example.umd.objects.Uname;

public class HomeScreen extends MainActivity {
    Button z_btn_signin;
    Button z_btn_rec;
    Button z_btn_nutr;
    Button z_btn_dietrec;
    Button z_btn_metric;
    Intent dailyWorkoutScreen;
    Intent recommendations;
    Intent DietaryAdvice;
    Intent dietaryInput;
    Intent MetricScreen;
    String testvar;
    Uname sharedData = Uname.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        z_btn_signin = (Button) findViewById(R.id.input_daily_workout);
        z_btn_rec = (Button) findViewById(R.id.exercise_rec_page);
        z_btn_nutr = (Button) findViewById(R.id.input_daily_nutrients);
        z_btn_metric = (Button) findViewById(R.id.nav_to_metrics);
        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        recommendations = new Intent(this, RecommendationScreen.class);
        DietaryAdvice = new Intent(this, DietAdviceScreen.class);
        dietaryInput = new Intent(this, DailyNutrientsScreen.class);
        MetricScreen = new Intent(this, MetricScreen.class);

        addWorkout();
        NavToRec();
//        NavToDietRec();
        addNutrient();
        NavToMetricScreen();
    }

    public void addWorkout() {

        z_btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(dailyWorkoutScreen);
            }
        });
    }
    public void addNutrient() {
        z_btn_nutr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(dietaryInput); }
        });
    }

    public void NavToRec() {
        z_btn_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(recommendations); }
        });
    }
    public void NavToDietRec() {
        z_btn_dietrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(DietaryAdvice); }
        });
    }

    public void NavToMetricScreen() {
        z_btn_metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(MetricScreen); }
        });
    }
}

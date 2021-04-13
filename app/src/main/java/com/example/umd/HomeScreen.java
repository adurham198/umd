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
    Intent dailyWorkoutScreen;
    Intent recommendations;
    Intent DietaryAdvice;
    Intent dietaryInput;
    String testvar;
    Uname sharedData = Uname.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        z_btn_signin = (Button) findViewById(R.id.input_daily_workout);
        z_btn_rec = (Button) findViewById(R.id.navtoRec);
        z_btn_dietrec = (Button) findViewById(R.id.navtoDietRec);
        z_btn_nutr = (Button) findViewById(R.id.input_daily_nutrients);

        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        recommendations = new Intent(this, RecommendationScreen.class);
        DietaryAdvice = new Intent(this, DietAdviceScreen.class);
        dietaryInput = new Intent(this, DailyNutrientsScreen.class);
        addWorkout();
        NavToRec();
        NavToDietRec();
        addNutrient();
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

}

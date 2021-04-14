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
    Button z_btn_calc;
    Button z_btn_deletion;
    Intent dailyWorkoutScreen;
    Intent recommendations;
    Intent DietaryAdvice;
    Intent dietaryInput;
    Intent Calculator;
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
        z_btn_calc = (Button) findViewById(R.id.CalculatorButton);
        z_btn_deletion = (Button) findViewById(R.id.inputDeletion);

        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        recommendations = new Intent(this, RecommendationScreen.class);
        DietaryAdvice = new Intent(this, DietAdviceScreen.class);
        dietaryInput = new Intent(this, DailyNutrientsScreen.class);
        Calculator = new Intent(this, Calculator.class);

        addWorkout();
        NavToRec();
        NavToDietRec();
        addNutrient();
        NavToCalc();
        InputDeletion();
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
    public void InputDeletion() {
        z_btn_deletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(HomeScreen.this, DeletionActivity.class)); }
        });
    }

    public void NavToCalc() {
        z_btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(Calculator);}
        });

    }


}

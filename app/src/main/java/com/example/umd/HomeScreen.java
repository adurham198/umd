package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.umd.objects.Player;
import com.example.umd.objects.SharedDate;
import com.example.umd.objects.Uname;

public class HomeScreen extends MainActivity {
    Button z_btn_signin;
    Button z_btn_rec;
    Button z_btn_nutr;
    Button z_btn_dietrec;
    Button z_btn_calc;
    Button z_btn_deletion;
    Button z_btn_metric;
    Button z_btn_update;
    Intent dailyWorkoutScreen;
    Intent recommendations;
    Intent DietaryAdvice;
    Intent dietaryInput;
    Intent Calculator;
    Intent DeletionActivity;
    Intent MetricScreen;
    Intent UpdateScreen;
    String testvar;
    SharedDate d = SharedDate.getInstance();
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
        z_btn_metric = (Button) findViewById(R.id.MetricScreen_btn);
        z_btn_update = (Button) findViewById(R.id.update_btn);
        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        recommendations = new Intent(this, RecommendationScreen.class);
        DietaryAdvice = new Intent(this, DietAdviceScreen.class);
        dietaryInput = new Intent(this, DailyNutrientsScreen.class);
        Calculator = new Intent(this, Calculator.class);
        DeletionActivity = new Intent(this, DeletionActivity.class);
        MetricScreen = new Intent(this, com.example.umd.MetricScreen.class);
        //UpdateScreen = new Intent(this, com.example.umd.UpdateScreen.class);
        d.setValue();
        addWorkout();
        NavToRec();
        NavToDietRec();
        addNutrient();
        NavToCalc();
        InputDeletion();
        NavToMetrics();
        //NavToUpdate();
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
            public void onClick(View v) { startActivity(DeletionActivity); }
        });
    }

    public void NavToCalc() {
        z_btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(Calculator);}
        });

    }
    public void NavToMetrics() {
        z_btn_metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(MetricScreen);}
        });
    }
/*    public void NavToUpdate() {
        z_btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(UpdateScreen);
            }
        });
    }*/
}

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
    Intent dailyWorkoutScreen;
    String testvar;
    Uname sharedData = Uname.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        z_btn_signin = (Button) findViewById(R.id.input_daily_workout);
        dailyWorkoutScreen = new Intent(this, DailyWorkoutScreen.class);
        testvar = sharedData.getValue();
        Log.d("U S E R N A M E ", testvar);
        addWorkout();
    }

    public void addWorkout() {

        z_btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(dailyWorkoutScreen);
            }
        });
    }

}

package com.example.umd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.umd.objects.Player;
import com.example.umd.objects.Uname;

public class MainActivity extends Activity {

    private SQLiteDatabaseHandler db;
    Button register_btn;
    Button login_btn;
    Intent registerplayer;
    Intent login;
    Intent HomeScreen;
    Intent DailyWorkoutScreen;
    Intent Recommendations;
    Intent DietaryAdvice;
    Intent DailyNutrientScreen;
    Intent MetricScreen;
    Player player1 = new Player();
    SQLiteDatabaseHandler dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register_btn = (Button) findViewById(R.id.initial_register_btn);
        login_btn = (Button) findViewById(R.id.initial_login_btn);
        registerplayer = new Intent(MainActivity.this, Register.class);
        login = new Intent(MainActivity.this, Login.class);
        HomeScreen = new Intent(MainActivity.this, HomeScreen.class);
        DailyWorkoutScreen = new Intent(MainActivity.this, DailyWorkoutScreen.class);
        Recommendations = new Intent(MainActivity.this, RecommendationScreen.class);
       // DietaryAdvice = new Intent(MainActivity.this, DietAdviceScreen.class);
        DailyNutrientScreen = new Intent(MainActivity.this, com.example.umd.DailyNutrientsScreen.class);
        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();
        gotoLogin();
        gotoregister();
    }

    public void gotoregister() {
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerplayer);
            }
        });
    }
    public void gotoLogin() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });
    }
}

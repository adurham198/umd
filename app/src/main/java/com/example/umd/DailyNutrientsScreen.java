package com.example.umd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.umd.objects.Nutrients;
import com.example.umd.objects.Uname;
import com.example.umd.objects.Workouts;

import java.text.ParseException;
import java.util.Date;

public class DailyNutrientsScreen extends MainActivity{
    Intent dailyNutrientScreen;
    Intent homeScreen;
    Button b_btn_AddNutrient;
    EditText b_Calories;
    EditText b_Carbs;
    EditText b_Protein;
    EditText b_Sugar;
    EditText b_Sleep;
    EditText b_Fat;
    EditText b_Cholesterol;
    EditText b_Fiber;
    Date currDate;
    Uname sharedData = Uname.getInstance();
    MainActivity ma;
    SQLiteDatabaseHandler dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_nutrient_input_screen);
        b_btn_AddNutrient = (Button) findViewById(R.id.button3);
        b_Calories = (EditText) findViewById(R.id.calories);
        b_Carbs = (EditText) findViewById(R.id.carbs);
        b_Protein= (EditText) findViewById(R.id.protein);
        b_Sleep = (EditText) findViewById(R.id.sleep);
        b_Sugar= (EditText) findViewById(R.id.sugar);
        b_Fat= (EditText) findViewById(R.id.fat);
        b_Cholesterol= (EditText) findViewById(R.id.cholesterol);
        b_Fiber = (EditText) findViewById(R.id.fiber);

        dailyNutrientScreen = new Intent(this, DailyNutrientsScreen.class);
        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();
        insertNutrient();
    }
    public void insertNutrient() {

        b_btn_AddNutrient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addNutrient();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                startActivity(HomeScreen);
            }
        });
    }

    public void addNutrient() throws ParseException {
        Nutrients nutrients = new Nutrients();
        String name = sharedData.getValue();

        int calories = Integer.parseInt(b_Calories.getText().toString());
        int carbs = Integer.parseInt(b_Carbs.getText().toString());
        int protein = Integer.parseInt(b_Protein.getText().toString());
        int sugar = Integer.parseInt(b_Sugar.getText().toString());
        int sleep = Integer.parseInt(b_Sleep.getText().toString());
        int fat = Integer.parseInt(b_Fat.getText().toString());
        int cholesterol = Integer.parseInt(b_Cholesterol.getText().toString());
        int fiber = Integer.parseInt(b_Fiber.getText().toString());

        nutrients.setName(name);
        nutrients.setTotalCalories(calories);
        nutrients.setTotalCarbs(carbs);
        nutrients.setTotalProtein(protein);
        nutrients.setTotalSugar(sugar);
        nutrients.setTotalSleep(sleep);
        nutrients.setTotalFat(fat);
        nutrients.setCholesterol(cholesterol);
        nutrients.setDietaryFiber(fiber);
        nutrients.setInputDate();
        Log.d("Nutrient date record ID", String.valueOf(nutrients.getDate()));
        dbhelper.addNutrients(nutrients);
    }
}

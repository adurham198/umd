package com.example.umd;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.umd.objects.Player;
import com.example.umd.objects.Uname;

import java.util.List;


//implements AdapterView.OnItemSelectedListener

public class Calculator extends MainActivity implements AdapterView.OnItemSelectedListener {
    TextView calc_calories;
    TextView calc_protien;
    TextView calc_fats;
    TextView calc_carbs;
    TextView calc_bmi;
    TextView calc_bmr;
    Uname sharedData = Uname.getInstance();
    List<Player> players;
    SQLiteDatabaseHandler dbhelper;
    Player thisPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calculator_screen);

        calc_calories = (TextView) findViewById(R.id.calories_calc);
        calc_protien = (TextView) findViewById(R.id.protien_calc);
        calc_fats = (TextView) findViewById(R.id.fat_calc);
        calc_carbs = (TextView) findViewById(R.id.carbs_calc);
        calc_bmi = (TextView) findViewById(R.id.bmi);
        calc_bmr = (TextView) findViewById(R.id.bmr);

        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();


        players = dbhelper.allPlayers();
        String thisPlayerName = sharedData.getValue();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getName().equals(thisPlayerName)) {
                thisPlayer = players.get(i);
            }
        }


        String[] goalChoices = new String[] {
                "Gain", "Lose", "Maintain"
        };

        Spinner goalSpinner = (Spinner) findViewById(R.id.GoalChoice);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, goalChoices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setAdapter(adapter);

        goalSpinner.setOnItemSelectedListener(this);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Double calories = calcCalories(position);
        calc_calories.setText(calories.toString().substring(0,4));
        calcMacros(calories, position);
        calcBMI();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView Decision = findViewById(R.id.Decision);
        String empty = "";
        Decision.setText(empty);


    }

    public void calcBMI(){
        double bmi = ((double) thisPlayer.getWeight() / (thisPlayer.getHeight() * thisPlayer.getHeight()))* 703.0;
        String bmiString = Double.toString(bmi).substring(0,4);
        calc_bmi.setText(bmiString);
    }


    public void calcMacros(Double calories, int position){
        Double protien = 0.0;
        Double fat = 0.0;
        Double carbs = 0.0;
        if(position == 0){
            protien = thisPlayer.getWeight() * 1.0;
            fat = (0.2 * calories) / 9;
            carbs = ((calories - (protien * 4) - (fat * 9)) / 4) - 1;

        }
        else if(position == 1){
            protien = (calories * 0.5) / 4;
            fat = (calories * .25) / 9;
            carbs = ((calories - (protien * 4) - (fat * 9)) / 4) - 1;
        }
        else{
            carbs = (calories * .5) / 4;
            fat = (calories / 4) / 9;
            protien = (calories - (carbs * 4) - (fat * 9)) / 4;

        }
        String protienString = protien.toString();
        calc_protien.setText(protienString.substring(0,protienString.indexOf('.')));

        String carbString = carbs.toString();
        calc_carbs.setText(carbString.substring(0,carbString.indexOf('.')));

        String fatString = fat.toString();
        calc_fats.setText(fatString.substring(0,fatString.indexOf('.')));



    }

    public Double calcCalories(int position){
        Double calories = 0.0;
        if(thisPlayer.getGender().startsWith("m") || thisPlayer.getGender().startsWith("M")){
            calories = calcBMRmale();
        }
        else{
            calories = calcBMRfemale();
        }
        switch (thisPlayer.getFreq()) {
            case "7":
                calories *= 1.9;
            case "6":
                calories *= 1.725;
            case "5":
            case "4":
                calories *= 1.55;
            case "3":
            case "2":
            case "1":
                calories *= 1.375;
            case "0":
                calories *= 1.2;
        }
        String bmr = calories.toString();
        calc_bmr.setText(bmr.substring(0,4));

        if(position == 0){
            calories *= 1.15;
        }

        else if(position == 1){
            calories -= 500;

        }

        return calories;
    }

    public Double calcBMRmale(){
        return (66 + (6.227 * (thisPlayer.getWeight())) + (1.9685 * thisPlayer.getHeight()) - (6.8 * thisPlayer.getAge()));
    }

    public Double calcBMRfemale(){
        return (655 + (4.3636 * thisPlayer.getWeight()) + (0.7087 * thisPlayer.getHeight()) - (4.7 * thisPlayer.getAge()));
    }



}

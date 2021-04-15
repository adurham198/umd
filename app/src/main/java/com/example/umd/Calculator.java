package com.example.umd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


//implements AdapterView.OnItemSelectedListener

public class Calculator extends MainActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_screen);

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
        TextView Decision = findViewById(R.id.Decision);
        String gain = "GAIN";
        String lose = "LOSE";
        String maintain = "MAINTAIN";
        if(position == 0){
            Decision.setText(gain);
        }
        else if(position == 1){
            Decision.setText(lose);
        }
        else {
            Decision.setText(maintain);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView Decision = findViewById(R.id.Decision);
        String empty = "";
        Decision.setText(empty);

    }

}

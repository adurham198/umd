package com.example.umd;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.umd.objects.Nutrients;
import com.example.umd.objects.Uname;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.Date;

public class MetricScreen extends MainActivity{
    TextView tvR, tvPython, tvCPP, tvJava;
    PieChart pieChart;
    Uname sharedData = Uname.getInstance();
    SQLiteDatabaseHandler dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric_screen);
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);
        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();
        setData();
    }
    private void setData(){
        tvPython.setText(Integer.toString(30));
        tvCPP.setText(Integer.toString(5));
        tvJava.setText(Integer.toString(25));
        String datevar = new Date().toString();
        Nutrients currNutr = new Nutrients();
        currNutr = dbhelper.getTodayMetric(sharedData.getValue());
        Log.d("Current Nutrients carbs", String.valueOf(currNutr.getTotalCarbs()));
        tvR.setText("" + String.valueOf(currNutr.getTotalCarbs()));
        pieChart.addPieSlice(
                new PieModel(
                        "R",
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "C++",
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));
// To animate the pie chart
        pieChart.startAnimation();
    }

}

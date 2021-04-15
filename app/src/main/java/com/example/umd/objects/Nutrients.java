package com.example.umd.objects;

import java.util.Date;

public class Nutrients {
    private String name;
    private int TotalCalories;
    private int TotalCarbs;
    private int TotalProtein;
    private int TotalSugar;
    private int TotalSleep;
    private int TotalFat;
    private int Cholesterol;
    private int dietaryFiber;
    private Date inputDate;

    public Nutrients() {
    }

    public Nutrients(String name, int TotalCalories, int TotalCarbs, int TotalProtein, int TotalSugar, int TotalSleep, int totalFat, int Cholesterol, int dietaryFiber, Date inputDate) {
        this.name = name;
        this.TotalCalories= TotalCalories;
        this.TotalCarbs = TotalCarbs;
        this.TotalProtein = TotalProtein;
        this.TotalSugar = TotalSugar;
        this.TotalSleep = TotalSleep;
        this.TotalFat = totalFat;
        this.Cholesterol = Cholesterol;
        this.dietaryFiber = dietaryFiber;
        this.inputDate = inputDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCalories() {
        return TotalCalories;
    }

    public void setTotalCalories(int TotalCalories) {
        this.TotalCalories = TotalCalories;
    }
    public int getTotalCarbs() {
        return TotalCarbs;
    }

    public void setTotalCarbs(int TotalCarbs) {
        this.TotalCarbs = TotalCarbs;
    }
    public int getTotalProtein() {
        return TotalProtein;
    }

    public void setTotalProtein(int TotalProtein) {
        this.TotalProtein= TotalProtein;
    }
    public int getTotalSugar() {
        return TotalSugar;
    }

    public void setTotalSugar(int TotalSugar) {
        this.TotalSugar = TotalSugar;
    }
    public int getTotalSleep() {
        return TotalSleep;
    }
    public void setTotalSleep(int TotalSleep) {
        this.TotalSleep = TotalSleep;
    }
    public int getTotalFat() {
        return TotalFat;
    }

    public void setTotalFat(int TotalFat) {
        this.TotalFat = TotalFat;
    }
    public int getCholesterol() {
        return Cholesterol;
    }

    public void setCholesterol(int TotalCholesterol) {
        this.Cholesterol= Cholesterol;
    }
    public int getDietaryFiber() {
        return dietaryFiber;
    }
    public void setDietaryFiber(int dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public Date getDate() {
        return inputDate;
    }
    public void setInputDate() {
        this.inputDate = new Date();
    }

}

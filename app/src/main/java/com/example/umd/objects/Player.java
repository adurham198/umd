package com.example.umd.objects;

public class Player {

    private String name;
    private int age;
    private String pass;
    private String gender;
    private int weight;
    private int height;
    private String freq;

    public Player() {
    }

    public Player( String name, Integer age, String pass, String gender, Integer weight, Integer height, String freq) {
        this.name = name;
        this.age = age;
        this.pass = pass;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.freq = freq;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }
    @Override
    public String toString() {
        return name + " - " + weight + " - " + height + " in";
    }

}
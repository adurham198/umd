package com.example.umd.objects;

public class Player {

    private int id;
    private String name;
    private String mobile;
    private String pass;
    private String gender;
    private int weight;
    private int height;
    private String freq;

    public Player() {
    }

    public Player(int id, String name, String mobile, String pass, String gender, Integer weight, Integer height, String freq) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.pass = pass;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.freq = freq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
        return name + " - " + weight + " - " + height + " cm";
    }

}
package com.example.umd.objects;

public class Uname {
    private static Uname instance = new Uname();

    public static Uname getInstance(){
        return Uname.instance;
    }
    public void SetInstance(Uname instance){
        Uname.instance = instance;
    }
    public static String username;
    private Uname() {

    }
    public String getValue(){
        return username;
    }
    public void setValue(String username){
        this.username = username;
    }
}

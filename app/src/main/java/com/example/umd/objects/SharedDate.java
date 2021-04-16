package com.example.umd.objects;

public class SharedDate {
    private static SharedDate instance = new SharedDate();
    public static SharedDate getInstance(){
        return SharedDate.instance;
    }
    public void SetInstance(SharedDate instance){SharedDate.instance = instance;
    }
    public static int rand;
    private SharedDate() {

    }
    public int getValue(){
        return rand;
    }
    public void setValue(){
        rand = 66;
        this.rand = rand;
    }

}

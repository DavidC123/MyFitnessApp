package com.example.david.myfitnessapp;

import java.io.Serializable;

public class Person implements Serializable {   //allows transfer of an instance of an object to another class
     String experience;  //how long user has trained in months
     int frequency;  //how many times a week of training
     String focus;  //type of training
    int currWeight;
    String improve;
    int targetWeight;


    public Person(int cw, String exp, int freq){
        this.currWeight=cw;
        this.experience=(exp);
        this.frequency=freq;
    }

    public Person(int cw, String exp, int freq, String foc, int targ, String imp){
        this.currWeight=cw;
        this.experience=(exp);
        this.frequency=freq;
        this.focus = foc;
        this.targetWeight = targ;
        this.improve=imp;
    }






    public static void main(String[] args) {


    }

}

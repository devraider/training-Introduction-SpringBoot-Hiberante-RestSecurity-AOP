package com.paulcristea.xye.paulcristea.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("Initiated +" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 100m as warm app";
    }
}

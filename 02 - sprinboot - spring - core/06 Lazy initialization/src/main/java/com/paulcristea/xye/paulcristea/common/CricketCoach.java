package com.paulcristea.xye.paulcristea.common;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Instance:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice some squads!sss";
    }
}

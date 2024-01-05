package com.paulcristea.xye.paulcristea.common;

import com.paulcristea.xye.paulcristea.common.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Instance:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice 30 min baseball";
    }
}

package com.paulcristea.xye.paulcristea.common;

import com.paulcristea.xye.paulcristea.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements Coach {

    public TennisCoach() {
        System.out.println("Instance:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice tennis";
    }
}

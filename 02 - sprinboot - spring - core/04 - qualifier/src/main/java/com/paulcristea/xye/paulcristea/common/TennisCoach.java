package com.paulcristea.xye.paulcristea.common;

import com.paulcristea.xye.paulcristea.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice tennis";
    }
}

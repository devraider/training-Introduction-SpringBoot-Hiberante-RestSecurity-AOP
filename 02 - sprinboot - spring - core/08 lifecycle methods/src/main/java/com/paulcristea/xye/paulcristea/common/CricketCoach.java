package com.paulcristea.xye.paulcristea.common;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)  // Default scope
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Instance:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice some squads!sss";
    }
}

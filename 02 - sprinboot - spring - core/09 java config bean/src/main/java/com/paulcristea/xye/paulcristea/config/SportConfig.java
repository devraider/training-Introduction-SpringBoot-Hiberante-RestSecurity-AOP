package com.paulcristea.xye.paulcristea.config;

import com.paulcristea.xye.paulcristea.common.Coach;
import com.paulcristea.xye.paulcristea.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

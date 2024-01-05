package com.pau.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune(boolean b) {
        if (b) {
            throw new RuntimeException("Exception because b: true");
        }
        try {

        TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
           throw new RuntimeException(i);
        }
        return "You are a millionaire";
    }
}

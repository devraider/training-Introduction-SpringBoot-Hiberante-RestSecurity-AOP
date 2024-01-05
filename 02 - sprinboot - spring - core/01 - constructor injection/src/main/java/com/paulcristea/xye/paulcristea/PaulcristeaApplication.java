package com.paulcristea.xye.paulcristea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.demo.springbootdemo"
})
public class PaulcristeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaulcristeaApplication.class, args);
	}

}

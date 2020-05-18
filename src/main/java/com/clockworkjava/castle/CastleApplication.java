package com.clockworkjava.castle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CastleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastleApplication.class, args);
	}
}
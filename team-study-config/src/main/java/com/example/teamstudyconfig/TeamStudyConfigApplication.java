package com.example.teamstudyconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TeamStudyConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamStudyConfigApplication.class, args);
	}

}

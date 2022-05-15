package com.filmassist.filmassist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.filmassist.filmassist")
public class FilmassistApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmassistApplication.class, args);
	}

}

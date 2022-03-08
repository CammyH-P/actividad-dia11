package com.actividad.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PracticaAct9Application {

	public static void main(String[] args) {
		SpringApplication.run(PracticaAct9Application.class, args);
	}
}

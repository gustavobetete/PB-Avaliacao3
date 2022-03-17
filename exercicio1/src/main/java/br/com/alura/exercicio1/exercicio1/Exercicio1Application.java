package br.com.alura.exercicio1.exercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class Exercicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio1Application.class, args);
	}

}
